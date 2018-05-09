package td.learn.tdbatis.v1;

import td.learn.mybatis.model.Person;

public interface PersonMapper {
    Person selectPersonById(String id);
}
