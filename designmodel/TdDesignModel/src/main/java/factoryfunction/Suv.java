package factoryfunction;


public class Suv implements ICar{

    @Override
    public String getCarType() {
        System.out.println("这是一个Suv");
        return "Suv";
    }
}
