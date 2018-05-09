package td.learn.tdbatis.v1;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy implements InvocationHandler {
    private ISqlsession sqlSession;
    public MapperProxy(ISqlsession sqlSession){
            this.sqlSession=sqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        sqlSession.selectOne(TdConfigrution.PersonMapper.sql,String.valueOf(args[0]));
        return null;
    }
}
