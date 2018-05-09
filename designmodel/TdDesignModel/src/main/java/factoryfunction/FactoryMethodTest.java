package factoryfunction;

public class FactoryMethodTest {
    public static void main(String[] args) {
        CarFactory carFactory =new CarFactory();
        ICar car=carFactory.getSuvCar();
        car.getCarType();
        ICar car2=carFactory.getCar();
        car2.getCarType();

    }
}
