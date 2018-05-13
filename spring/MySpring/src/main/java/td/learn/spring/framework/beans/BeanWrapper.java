package td.learn.spring.framework.beans;

import td.learn.spring.framework.myinterface.FactoryBean;

public class BeanWrapper implements FactoryBean {

    //会用到观察者模式，需要一个监听
private BeanPostProcessor beanPostProcessor;


    private Object wrapperInstance;
    //原生的通过反射new出来的，需要保存下来
    private Object originalInstance;


    public BeanWrapper(Object instance) {
        this.wrapperInstance = instance;
        this.originalInstance = instance;
    }


    public Object getWrapperInstance() {
        return wrapperInstance;
    }

//代理时要用
    public Class<?> getWrapperClass() {
        return wrapperInstance.getClass();
    }

    public BeanPostProcessor getBeanPostProcessor() {
        return beanPostProcessor;
    }

    public void setBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessor = beanPostProcessor;
    }
}
