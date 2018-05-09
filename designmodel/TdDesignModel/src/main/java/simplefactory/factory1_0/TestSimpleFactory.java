package simplefactory.factory1_0;

public class TestSimpleFactory {
    public static void main(String[] args) {
        PhoneFactory phoneFactory=new PhoneFactory();
        Phone phone=phoneFactory.getNewPhone("huawei");
        phone.getBrandName();
    }
}
