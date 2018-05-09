package td.learn.mybatis.dao;

import td.learn.mybatis.model.Person;

public interface IPersonMapper {

     String getNameById(int id);


     Person getPersoninfo(int id);

     int addPerson(Person p);
}
