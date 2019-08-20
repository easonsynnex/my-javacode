package com.yin.jicheng;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("小黑");
        dog.setFood("骨头");
        dog.eat();

        Cat cat  = new Cat();
        cat.setName("小喵");
        cat.setMonth(3);
        cat.sleep();
        List list = new ArrayList();
        list.add("a");
        list.get(0);

        Map map = new HashMap();
        map.put("name", "eason");
        map.get("name");

        System.out.println(Math.random());
        Random random = new Random();
        System.out.println(random.nextInt(5));
    }
}
