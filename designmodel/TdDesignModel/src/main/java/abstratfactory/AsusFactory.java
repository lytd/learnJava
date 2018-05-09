package abstratfactory;

public class AsusFactory extends ComputerFactory{

    @Override
    ICPU getCPU() {
        return new AMD();
    }

    @Override
    IMemory getMemory() {
        return new Samsung();
    }
}
