package com.yin.proxy.staticProxy;

import com.yin.proxy.UserDao;

/**
 * Created by easony on 05/11/18.
 */
public class TestStaticProxy {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        UserDaoProxy proxy = new UserDaoProxy(userDao);
        proxy.save();
    }
}
