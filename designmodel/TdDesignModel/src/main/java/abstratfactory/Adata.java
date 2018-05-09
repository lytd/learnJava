package abstratfactory;

public class Adata implements IMemory{
    @Override
    public void getMemorySize() {
        System.out.println("this is adata 16G memory");
    }
}
