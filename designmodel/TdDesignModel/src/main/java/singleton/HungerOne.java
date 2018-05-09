package singleton;

public class HungerOne {
    //通过静态变量的方式实现单例模式
    private static HungerOne hungerOne =new HungerOne();

    public static HungerOne getInstance() {
        return hungerOne;
    }
}
