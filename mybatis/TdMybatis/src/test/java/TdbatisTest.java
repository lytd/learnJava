import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import td.learn.mybatis.dao.IPersonMapper;
import td.learn.mybatis.model.Person;
import td.learn.mybatis.tdbatis.TdMybatisFunction;
import td.learn.mybatis.util.BusinessUtil;

import java.io.FileNotFoundException;

public class TdbatisTest{

    @Test
    public void addPersion() throws FileNotFoundException {
        SqlSession sqlSession= TdMybatisFunction.getSession();
        IPersonMapper iPersonMapper=sqlSession.getMapper(IPersonMapper.class);
        Person p=BusinessUtil.getNewPerson();
        //添加一个用户
        int i= iPersonMapper.addPerson(p);
        System.out.println(p);

        //Person p1= iPersonMapper.getNameById();
        //System.out.println(p1);


        TdMybatisFunction.closeSession(sqlSession);
    }

}
