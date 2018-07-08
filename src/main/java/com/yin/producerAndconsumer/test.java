package com.yin.producerAndconsumer;

import java.util.LinkedList;

/**
 * Created by easony on 06/08/18.
 */
public class test {

    public static void main(String[] args) {
        LinkedList<Object> num = new LinkedList<Object>();
        Thread p1 = new Thread(new Producer(num),"1");
        Thread p2 = new Thread(new Producer(num),"2");
        Thread p3 = new Thread(new Producer(num),"3");


        Thread c1 = new Thread(new Consumer(num),"1");
        Thread c2 = new Thread(new Consumer(num),"2");

        c1.start();
        c2.start();
        p1.start();
        p2.start();
        p3.start();

    }
}
