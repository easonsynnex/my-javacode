package com.yin.proxy;

/**
 * Created by easony on 05/11/18.
 */
public class UserDao implements IUserDao {

    public void save() {
        System.out.println("Save 成功！");
    }


    public void insert() {
        save();
    }
}
