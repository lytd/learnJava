package factoryfunction;

public class Car implements ICar{
    @Override
    public String getCarType() {
        System.out.println("这是一个Car");
        return "Car";
    }
}
