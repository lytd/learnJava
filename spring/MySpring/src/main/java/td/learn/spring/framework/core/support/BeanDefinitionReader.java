package td.learn.spring.framework.core.support;

import td.learn.spring.common.demo.util.StringUtil;
import td.learn.spring.framework.beans.BeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BeanDefinitionReader {
    //配置文件对象
    private Properties config = new Properties();
    //已经注册的bean的名称集合
    private List<String> registryBeanDefinitons = new ArrayList<>();

    private static final String SCAN_PACKAGE = "scanPackage";

    public BeanDefinitionReader(String[] configLocation) {

        //获取配置文件的资源流
        //TODO 现在只适配了一个配置文件
        InputStream in = getClass().getClassLoader().getResourceAsStream(configLocation[0].replace("classpath:", ""));
        try {
            config.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //扫描包
        doSacnner(this.config.getProperty(SCAN_PACKAGE));

    }

    private void doSacnner(String scanPackage) {
        //获取目标路径的url
        URL url = getClass().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File file = new File(url.getFile());
        //循环文件夹下的所有文件
        for (File f : file.listFiles()) {

            //判断是文件夹，则递归子文件夹
            if (f.isDirectory()) {
                doSacnner(scanPackage + "." + f.getName());
            } else {
                //判断是文件，则将其保存到列表中
                registryBeanDefinitons.add(scanPackage + "." + f.getName().replace(".class", ""));
            }
        }
    }

    /**
     * 返回已经扫描的类名称
     *
     * @return
     */
    public List<String> loadBeanDefinition() {
        return registryBeanDefinitons;
    }

    /**
     * 对需要注册的bean进行一个信息包装
     * @param className 需要注册的bean
     * @return BeanDefinition对象
     */
    public BeanDefinition registryBean(String className) {
        if (this.registryBeanDefinitons.contains(className)) {
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setBeanClassname(className);
            beanDefinition.setFactoryBeanName(StringUtil.getFirstLower(className.substring(className.lastIndexOf(".") + 1)));
        return beanDefinition;
        }
        return null;
    }

    /**
     * 获取配置文件对象
     *
     * @return
     */
    public Properties getConfig() {
        return this.config;
    }
}
