package proxy.jdk;

public class JDKProxyTest {

    public static void main(String[] args) {
        Doctor lisi= (Doctor) new JDKProxy().getInstance(new Lisi());
        lisi.doOperation();
        lisi.havearest();
    }

}
