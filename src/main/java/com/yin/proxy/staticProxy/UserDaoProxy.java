package com.yin.proxy.staticProxy;

import com.yin.proxy.IUserDao;
import com.yin.proxy.UserDao;

/**
 * Created by easony on 05/11/18.
 * Desciption: 静态代理可以做到不修改目标对象的功能的前提下，对目标功能进行扩展
 * 缺点: 因为代理对象需要维护与目标对象一样的接口，所以会有很多代理类，同时，如果接口增加方法，目标对象与代理对象都需要维护
 */
public class UserDaoProxy implements IUserDao{

    IUserDao userDao;
    public UserDaoProxy(IUserDao userDao){
        this.userDao = userDao;
    }

    public void save(){
        System.out.println("开始保存前....");
        userDao.save();
        System.out.println("保存后...");
    }

    @Override
    public void insert() {

    }
}
