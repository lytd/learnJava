package td.learn.tdbatis.v1;

import td.learn.mybatis.model.Person;

public class TdbatisTest {
    public static void main(String[] args) {
        TdConfigrution tc=new TdConfigrution();
        IExector iExector=new TdExcetor();
        ISqlsession iSqlsession=new TdSqlSession(tc,iExector);
        PersonMapper p= iSqlsession.getMapper(PersonMapper.class);
        Person p1=p.selectPersonById("2");
        System.out.println(p1);
    }
}
