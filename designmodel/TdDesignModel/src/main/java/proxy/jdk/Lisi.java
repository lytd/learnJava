package proxy.jdk;

public class Lisi implements Doctor{

    @Override
    public void doOperation() {
        System.out.println("李四做外科手术");
    }

    @Override
    public void havearest() {
        System.out.println("休息一下");
    }
}
