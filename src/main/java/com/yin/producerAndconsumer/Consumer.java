package com.yin.producerAndconsumer;

import java.util.LinkedList;

/**
 * Created by easony on 06/08/18.
 */
public class Consumer implements Runnable {
    private LinkedList<Object> num;

    public Consumer(LinkedList<Object> num) {
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (num){
            while (num.size() == 0) {//用while不能用if，用if可能其他消费者将资源消费完了，当前线程再消费会出错
                System.out.println("仓库为空");
                try {
                    num.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num.remove();
            System.out.println("消费者"+ Thread.currentThread().getName()+ "消费了1...还剩" + num.size());
            num.notifyAll();
        }
    }
}
