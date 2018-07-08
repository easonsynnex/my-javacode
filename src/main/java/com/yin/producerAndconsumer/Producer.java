package com.yin.producerAndconsumer;

import java.util.LinkedList;

/**
 * Created by easony on 06/08/18.
 */
public class Producer implements Runnable {
    private LinkedList<Object> num;

    public Producer(LinkedList<Object> num) {
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (num){
            while (num.size() == 5) {
                try {
                    num.wait();//
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num.add(new Object());
            System.out.println("生产者" + Thread.currentThread().getName()+ "生产了...还剩" + num.size());
            num.notifyAll();
        }
    }
}
