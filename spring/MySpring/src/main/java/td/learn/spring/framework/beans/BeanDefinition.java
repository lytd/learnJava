package td.learn.spring.framework.beans;

public class BeanDefinition {

    private String beanClassname;
    private String factoryBeanName;
    private boolean lazyInit=false;

    public String getBeanClassname() {
        return beanClassname;
    }

    public void setBeanClassname(String beanClassname) {
        this.beanClassname = beanClassname;
    }

    public String getFactoryBeanName() {
        return factoryBeanName;
    }

    public void setFactoryBeanName(String factoryBeanName) {
        this.factoryBeanName = factoryBeanName;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }
}
