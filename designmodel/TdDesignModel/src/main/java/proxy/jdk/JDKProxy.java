package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    private Doctor doctor;

    public Object getInstance(Doctor doctor){
        this.doctor=doctor;
        Class<?> clazz=doctor.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前");
        method.invoke(this.doctor,args);
        System.out.println("代理后");
        return null;
    }
}
