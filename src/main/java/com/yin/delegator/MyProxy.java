package com.yin.delegator;

import com.yin.proxy.IUserDao;
import com.yin.proxy.UserDao;
import com.yin.springDI.Entity.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by easony on 05/17/18.
 */
public class MyProxy implements InvocationHandler {
    Object target;
    Object proxyTarget;

    public MyProxy(Object target) {
        this.target = target;
        this.proxyTarget = getInstance();
    }

    public Object getProxyTarget() {
        return proxyTarget;
    }

    public Object getInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            String methodName = method.getName();
            System.out.println("执行方法名：" + methodName + " ");
            if (methodName.equals("save")) {
                return method.invoke(target, args);
            }
            return method.invoke(target, args);
        } catch (InvocationTargetException e){
            throw e.getCause();
        }
    }

    public static void main(String[] args) {
        IUserDao user = new UserDao();
        MyProxy proxy = new MyProxy(user);
        IUserDao proxyUser = (IUserDao) proxy.getProxyTarget();
        System.out.println(proxyUser.getClass());
        proxyUser.save();
    }
}
