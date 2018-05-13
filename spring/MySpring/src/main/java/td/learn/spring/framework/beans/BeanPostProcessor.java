package td.learn.spring.framework.beans;

public class BeanPostProcessor  {

    public Object postProcessorBeforeInitalization(Object bean ,String beanName){
        return bean;
    }


    public Object postProcessorAfterInitalization(Object bean ,String beanName){
        return bean;
    }
}
