package abstratfactory;

public abstract class ComputerFactory {
    abstract ICPU getCPU();
    abstract IMemory getMemory();
}
