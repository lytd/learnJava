package abstratfactory;

public class Intel implements ICPU{
    @Override
    public void getCPUName() {
        System.out.println("this is an intel CPU");
    }
}
