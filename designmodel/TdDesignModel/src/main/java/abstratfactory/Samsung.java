package abstratfactory;

public class Samsung implements IMemory{
    @Override
    public void getMemorySize() {
        System.out.println("samsung 8G memory");
    }
}
