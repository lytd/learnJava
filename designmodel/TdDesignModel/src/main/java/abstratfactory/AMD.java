package abstratfactory;

public class AMD implements ICPU{

    @Override
    public void getCPUName() {
        System.out.println("this is an AMD CPU");
    }
}
