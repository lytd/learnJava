package proxy.cglib;

public class CGlibTest {
    public static void main(String[] args) {
        ZhanSan zhanSan= (ZhanSan) new CglibProxy().getProxy(ZhanSan.class);
        zhanSan.findjob();
    }
}
