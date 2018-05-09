package prototype.simple;

import lombok.Data;


public class Sheep implements Cloneable{
     String name;
     int age;
     Sheep sheep;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
