package com.yin.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by easony on 05/11/18.
 * Description: 创建动态代理对象，动态代理不需要实现接口，但是要制定接口类型
 */
public class ProxyFactory {
    //要代理的一个对象
    Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }

    //给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                //lambda表达式
                (Object proxy, Method method, Object[] args) -> {
                    System.out.println("开始前...");
                    //执行目标对象方法
                    //注意：这里用的是要代理对象target
                    Object value = method.invoke(target, args);
                    System.out.println("结束后...");
                    return value;
                }
                /*new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始前...");
                        Object value = method.invoke(target, args);
                        System.out.println("结束后...");
                        return value;
                    }
                }*/);
    }
}
