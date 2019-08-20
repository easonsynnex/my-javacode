package com.yin.jicheng;

public class Dog extends Animal {
    private String food;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void eat(){
        System.out.println(this.getName() + "喜欢吃" + this.food);
    }
}
