import DAOImpl.persionDao;
import bean.Persion;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        persionDao persion=new persionDao();

//        persion.listAllPersion();

//        persion.listByGender("F");

//        Persion p=new Persion();
//        p.setId(2);
//        p.setName("testname2");
//        p.setGender("M");
//        p.setAddress("shandong");
//        persion.insertPersion(p);

//         Persion p=new Persion();
//         p.setId(1);
//        p.setName("tesdfadt");
//        persion.updatePersion(p);

        Map<String,Object> map=new HashMap<String, Object>();
        map.put("name","helloworld");
        map.put("id",1);
        persion.updatebyMap(map);
// test1 , test2

    }
}
