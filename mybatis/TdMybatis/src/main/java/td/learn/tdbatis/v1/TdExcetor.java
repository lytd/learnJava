package td.learn.tdbatis.v1;

import java.util.List;

public class TdExcetor implements IExector{


    public List query(String statment, String preparment) {

        System.out.println("调用jdbc查询sql："+statment );
        System.out.println(preparment);
        System.out.println("封装结果集");
        return null;
    }
}
