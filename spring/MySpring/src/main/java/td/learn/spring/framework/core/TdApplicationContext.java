package td.learn.spring.framework.core;

import td.learn.spring.framework.annotation.TdAutoWried;
import td.learn.spring.framework.annotation.TdController;
import td.learn.spring.framework.annotation.TdService;
import td.learn.spring.framework.beans.BeanDefinition;
import td.learn.spring.framework.beans.BeanPostProcessor;
import td.learn.spring.framework.beans.BeanWrapper;
import td.learn.spring.framework.core.support.BeanDefinitionReader;
import td.learn.spring.framework.myinterface.BeanFactroy;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TdApplicationContext implements BeanFactroy {
    //配置文件的路径
    private String[] configLocations;
    //加载配置文件的reader
    private BeanDefinitionReader reader;
    //ioc容器
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    //所有单例的对象的容器
    private Map<String, Object> beanCacheMap = new ConcurrentHashMap<>();
    //用来存储所有被代理的对象
    private Map<String, BeanWrapper> beanWrapperMap = new ConcurrentHashMap<>();

    public TdApplicationContext(String... configLocations) {
        //将配置文件保存到数组中
        this.configLocations = configLocations;
        //刷新
        refresh();

    }

    private void refresh() {

        //定位-->解析所有的配置文件
        this.reader = new BeanDefinitionReader(this.configLocations);

        //加载-->获取到所有需要注册的class
        List<String> beanDefinitions = reader.loadBeanDefinition();
        //注册-->对需要注册的bean对象进行注册
        doRegirtry(beanDefinitions);
        //自动注入
        doAutoWried();

        System.out.println("1234");

    }

    private void doAutoWried() {
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            if (!entry.getValue().isLazyInit()){
                getBean(entry.getKey());
            }
        }

    }

    private void populateBean(String beanName,Object instace) throws IllegalAccessException {

        Class<?> clazz=instace.getClass();
        //判断是否是service或者controller
        if(!(clazz.isAnnotationPresent(TdController.class)||clazz.isAnnotationPresent(TdService.class))){
            return;
        }
        Field[] fields=clazz.getDeclaredFields();
        for(Field field:fields){
            //判断是否是AutoWried注解
            if(!field.isAnnotationPresent(TdAutoWried.class)){
                continue;
            }
            //拿到注解对象
            TdAutoWried tdAutoWried=field.getAnnotation(TdAutoWried.class);
            //获取注解自定义的值
            String autoWriedBeanName=tdAutoWried.value().trim();
            if(autoWriedBeanName.equals("")){
                autoWriedBeanName=field.getType().getName();
            }
            field.setAccessible(true);

            field.set(instace,beanWrapperMap.get(autoWriedBeanName).getWrapperInstance());


        }



    }

    private void doRegirtry(List<String> beanDefinitions) {
        try {
            for (String classname : beanDefinitions) {

                //拿到bean的class对象
                Class<?> clazz = Class.forName(classname);
                //判断是否为接口，接口不能实例化
                if (clazz.isInterface()) {
                    continue;
                }
                //对对象进行包装
                BeanDefinition beanDefinition = reader.registryBean(classname);
                if (beanDefinition != null) {
                    //将包装成功的bean保存到map中

                    beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), beanDefinition);
                }

                //将该类的接口，由实现类进行实例化
                Class[] interfaces = clazz.getInterfaces();
                for (Class i : interfaces) {
                    beanDefinitionMap.put(i.getName(), beanDefinition);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanName) {

        try {

            //创建一个通知
            BeanPostProcessor beanPostProcessor = new BeanPostProcessor();

            //根据类名拿到beandefinition对象
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);


            //获取一个deandefinition对象的包装类
            Object instance = instantionBean(beanDefinition);
            if (instance == null) {
                return null;
            }

            //创建对象之前调用一次
            beanPostProcessor.postProcessorBeforeInitalization(instance, beanName);
            BeanWrapper beanWrapper = new BeanWrapper(instance);
            beanWrapper.setBeanPostProcessor(beanPostProcessor);

            //创建对象之前调用一次
            beanPostProcessor.postProcessorAfterInitalization(instance, beanName);
            //进行注入
            populateBean(beanName,instance);

            //获取到实例后
            return beanWrapperMap.get(beanName).getWrapperInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }


    private Object instantionBean(BeanDefinition beanDefinition) throws Exception {

        Object instance;
        String className = beanDefinition.getBeanClassname();


        //TODO 需要添加判断是否时单例方法
        //判断是否在容器中
        if (beanCacheMap.containsKey(className)) {
            instance = beanCacheMap.get(className);
        } else {
            //通过反射创建实例，保存对容器中
            instance = Class.forName(className).newInstance();
            beanCacheMap.put(className, instance);
        }


        return null;
    }
}
