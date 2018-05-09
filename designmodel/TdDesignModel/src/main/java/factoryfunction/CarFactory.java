package factoryfunction;

public class CarFactory {
    public ICar getSuvCar(){
        return new Suv();
    }

    public ICar getCar(){
        return new Car();
    }
}
