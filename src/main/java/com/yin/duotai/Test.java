package com.yin.duotai;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void show(Animal animal){
        animal.eat();
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        show(dog);
        show(cat);
        List list = new ArrayList();
    }
}
