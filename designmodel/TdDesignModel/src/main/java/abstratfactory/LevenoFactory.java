package abstratfactory;

public class LevenoFactory extends ComputerFactory{

    @Override
    ICPU getCPU() {
        return new Intel();
    }

    @Override
    IMemory getMemory() {
        return new Adata();
    }
}
