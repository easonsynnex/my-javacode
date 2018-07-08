package com.yin.proxy.dynamicProxy;

import com.yin.proxy.IUserDao;
import com.yin.proxy.UserDao;

/**
 * Created by easony on 05/11/18.
 */
public class TestDynamicProxy {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        //目标对象
        System.out.println(userDao.getClass());
        //给目标对象创建代理对象
        IUserDao proxy = (IUserDao)new ProxyFactory(userDao).getProxyInstance();
        //内存中动态生成的代理对象
        System.out.println(proxy.getClass());
        proxy.insert();
    }
}
