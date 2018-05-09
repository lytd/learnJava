package singleton;

public class LazyTwo {
    private static LazyTwo lazyTwo;

    public synchronized LazyTwo  getInstance() {

            if (null==lazyTwo){
                lazyTwo=new LazyTwo();
            }

        return lazyTwo;
    }
}
