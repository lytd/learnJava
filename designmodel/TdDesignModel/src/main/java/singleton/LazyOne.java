package singleton;

public class LazyOne {
    //通过静态变量的方式实现单例模式
    private static LazyOne lazyOne;

    public static LazyOne getInstance() {
        if(null==lazyOne){
            //此处在并发模式下 会有问题
            lazyOne=new LazyOne();

        }
        return lazyOne;
    }
}
