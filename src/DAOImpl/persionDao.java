package DAOImpl;

import bean.Persion;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by taylor on 7/14/14.
 */
public class persionDao {
    private SqlMapClient getSqlMapClient(){
        SqlMapClient sqlMapClient=null;
        try {
            Reader reader= Resources.getResourceAsReader("config/ibatis.xml");
            sqlMapClient= SqlMapClientBuilder.buildSqlMapClient(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlMapClient;
    }
    public List<Persion> listAllPersion(){
        List<Persion> list=null;
        try {
            list=getSqlMapClient().queryForList("getAll");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
        return list;
    }
    public  List<Persion> listByGender(String gender){
        List<Persion>list=null;
        try {
            list=getSqlMapClient().queryForList("byGender",gender);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
        return list;
    }

    public void insertPersion(Persion persion){
        try {
            getSqlMapClient().insert("insert",persion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatePersion(Persion persion){
        try {
            getSqlMapClient().update("update",persion);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void updatebyMap(Map<String,Object> map){
        try {
            getSqlMapClient().update("update2",map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
