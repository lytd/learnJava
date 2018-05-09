package td.learn.mybatis.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person {
    private int id;
    private String name;
    private String remark;
    private int age;
    private String insertTime;

    public Person(){

    }

    public Person(String name, String remark, int age, String insertTime) {
        this.name = name;
        this.remark = remark;
        this.age = age;
        this.insertTime = insertTime;
    }
}
