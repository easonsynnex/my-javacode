package com.yin.springDI.service;

import com.yin.springDI.Entity.User;
import com.yin.springDI.annotation.MyAutowired;
import com.yin.springDI.annotation.MyComponent;

@MyComponent
public class UserService {
    @MyAutowired
    User user1;

    @MyAutowired
    User user2;

    public void login(){
        System.out.println("user1:" + user1.hashCode());
        System.out.println("user2:" + user2.hashCode());
    }
}
