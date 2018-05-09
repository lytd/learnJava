package td.learn.mybatis.util;

import td.learn.mybatis.model.Person;

public class BusinessUtil {
    public static Person getNewPerson(){
        return new Person("tony","remarkTest",12,DateUtil.getNow());
    }
}
