package com.yin.springDI.Entity;

import com.yin.springDI.annotation.MyComponent;
import com.yin.springDI.annotation.MyValue;

@MyComponent(scope = "prototype")
public class User {
    @MyValue("eason")
    private String userName;
    @MyValue("123456")
    private String passWord;
    @MyValue("18")
    private int age;

    public User() {
        System.out.println("User 无参构造函数执行");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age=" + age +
                '}';
    }
}

