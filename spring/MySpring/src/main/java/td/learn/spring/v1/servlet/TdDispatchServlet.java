package td.learn.spring.v1.servlet;

import td.learn.spring.v1.annotation.TdAutoWried;
import td.learn.spring.v1.annotation.TdController;
import td.learn.spring.v1.annotation.TdService;
import td.learn.spring.v1.demo.action.MyAction;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class TdDispatchServlet extends HttpServlet {
    private Properties configContext = new Properties();

    private Map<String, Object> ioc = new ConcurrentHashMap<>();

    private ArrayList<String> classNames = new ArrayList<String>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用Post方法");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //定位
        doLocation(config.getInitParameter("configLocation"));
        //加载
        doSacnner(configContext.getProperty("scanPackage"));
        //注册
        doRegistry();
        //注入
        doAutoWried();


       MyAction my= (MyAction) ioc.get("myAction");
       String r=my.queryName("Td");
        System.out.println(r);
    }

    private void doAutoWried() {
        try {
            //便利IOC容器中所有的类的字段
            for (Map.Entry<String, Object> entry : ioc.entrySet()) {
                //将AutoWried注解的字段拿到
                Field[] fields = entry.getValue().getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (!field.isAnnotationPresent(TdAutoWried.class)) continue;


                    TdAutoWried tdAutoWried=field.getAnnotation(TdAutoWried.class);
                    String beanName=tdAutoWried.value().trim();
                    if("".equals(beanName)){
                        beanName=field.getType().getName();
                    }
                    field.setAccessible(true);
                    //将值注入
                    field.set(entry.getValue(),ioc.get(beanName));


                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void doRegistry() {
        //拿到所有的类的Class文件
        for (String str : classNames) {

            try {
                //判断class文件的注解属性，然后将其实例保存到ioc容器中
                Class<?> clazz = Class.forName(str);
                String beanName = null;
                //判断注解类型
                if (clazz.isAnnotationPresent(TdController.class)) {

                        beanName = getFirstLower(clazz.getSimpleName());
                    Object obj=clazz.newInstance();
                    ioc.put(beanName, obj);

                } else if (clazz.isAnnotationPresent(TdService.class)) {

                        beanName = getFirstLower(clazz.getSimpleName());
                        Object obj=clazz.newInstance();

                    ioc.put(beanName, obj);
                    //判断是否为接口

                    Class<?>[] interfaces = clazz.getInterfaces();

                    for (Class<?> i :interfaces){
                        ioc.put(i.getName(),obj);
                    }
                } else {
                    continue;
                }



            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }


    private void doSacnner(String scanPackage) {
        //获取目标路径的url
        URL url = getClass().getResource("/"+scanPackage.replaceAll("\\.", "/"));
        File file = new File(url.getFile());
        //循环文件夹下的所有文件
        for (File f : file.listFiles()) {

            //判断是文件夹，则递归子文件夹
            if (f.isDirectory()) {
                doSacnner(scanPackage + "." + f.getName());
            } else {
                //判断是文件，则将其保存到列表中
                classNames.add(scanPackage + "." + f.getName().replace(".class", ""));
            }
        }
    }

    private void doLocation(String configPath) {
        //获取配置文件的资源流
        InputStream in = getClass().getClassLoader().getResourceAsStream(configPath.replace("classpath:", ""));
        try {
            configContext.load(in);
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

    }

    private String getFirstLower(String str){
        char[] letters=str.toCharArray();
        letters[0]+=32;
        return String.valueOf(letters);

    }
}
