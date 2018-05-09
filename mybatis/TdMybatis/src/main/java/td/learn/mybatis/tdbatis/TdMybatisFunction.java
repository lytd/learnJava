package td.learn.mybatis.tdbatis;

import td.learn.mybatis.dao.IPersonMapper;
import td.learn.mybatis.model.Person;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TdMybatisFunction {
    public static SqlSession getSession() throws FileNotFoundException {
        File f = new File("D:\\学习\\咕泡架构\\xuexi\\myowner\\源码\\mybatis\\TdMybatis\\src\\main\\resources\\mybatis-config.xml");

        FileInputStream fi = new FileInputStream(f);
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(fi);
        return factory.openSession();

    }



    public static void closeSession(SqlSession sqlSession){
        sqlSession.commit();
        sqlSession.close();
    }
}
