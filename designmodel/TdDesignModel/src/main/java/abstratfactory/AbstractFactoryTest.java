package abstratfactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        ComputerFactory computerFactory=new AsusFactory();
        computerFactory.getCPU().getCPUName();
        computerFactory.getMemory().getMemorySize();

        ComputerFactory computerFactory1=new LevenoFactory();
        computerFactory1.getMemory().getMemorySize();
        computerFactory1.getCPU().getCPUName();

    }
}
