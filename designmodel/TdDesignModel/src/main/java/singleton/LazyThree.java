package singleton;

public class LazyThree {
    private boolean isnew=true;

    private LazyThree(){
        synchronized (InnerClass.class){
            if (isnew){
                isnew=!isnew;
            }
        }
    }

    public static final LazyThree getInstance(){
        return InnerClass.lazy;
    }


    private static class InnerClass{
        private static LazyThree lazy=new LazyThree();
    }
}
