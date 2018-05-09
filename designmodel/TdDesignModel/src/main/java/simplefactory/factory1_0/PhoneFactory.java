package simplefactory.factory1_0;

public class PhoneFactory {


    public Phone getNewPhone(String brandname){
        switch(brandname){
            case "Iphone":
                return new IPhone();

            case "OPPE":
                return new OPPOPhone();

            case "VIVO":
                return new VIVOPhone();

            default:
                System.out.println("不生产这种品牌的手机");
                return null;

        }
    }
}
