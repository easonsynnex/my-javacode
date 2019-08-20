package com.yin.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc 泛型类和泛型方法
 * @param <T>
 */
public class RandomList<T> {

    List<T> list = new ArrayList<>();


    public void add(T e){
        list.add(e);
    }

    public T select(){
        return list.get(0);
    }

    /**
     * @desc 泛型方法
     * @param e
     * @param w
     * @param <E>
     * @param <W>
     */
    public <E, W> void genericMethod(E e, W w){
        System.out.println(e.getClass().getSimpleName() + " " + e.toString()
                +"\r" + w.getClass().getSimpleName() + " " + w.toString());
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<>();
        randomList.add("eason");
        randomList.add("18");
        randomList.add("sichuan");

        System.out.println(randomList.select());
        randomList.genericMethod(10, "hello");
        randomList.genericMethod(10.3f, true);
    }
}
