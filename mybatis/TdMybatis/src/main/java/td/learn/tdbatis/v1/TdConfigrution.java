package td.learn.tdbatis.v1;

import java.lang.reflect.Proxy;

public class TdConfigrution {
    public <T> T getMapper(Class<T> clazz,ISqlsession sqlSession) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new MapperProxy(sqlSession));
    }
    static class PersonMapper{
       static String namesapce="";
        static String sql="select * from person where id=#{id}";
        static String id="";



    }
}
