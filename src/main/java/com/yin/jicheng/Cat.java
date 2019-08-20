package com.yin.jicheng;

public class Cat extends Animal {
    private int month;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void sleep(){
        System.out.println(this.month + "个月大的小猫"+getName()+"喜欢睡觉");
    }
}
