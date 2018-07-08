package com.yin.CountDownLatch;

import org.apache.tools.ant.taskdefs.Sleep;

import java.util.concurrent.CountDownLatch;

/**
 * Created by easony on 05/24/18.
 */
public class TestCountDownLatch {
        static int num = 10;
        static CountDownLatch count = new CountDownLatch(num);

        public static void main(String[] args) throws InterruptedException {
            System.out.println("所有线程开始执行");
            for (int i = 0;i < num ; i++){
                new Thread(){
                    public void run(){
                        System.out.println(Thread.currentThread().getName() + " 开始...");
                        try {
                            count.countDown();//计数器减1

                            count.await();//调用await()方法的线程会被挂起，指导锁存计数器为0
                            Thread.sleep(1000);//doSomeThing()
                            System.out.println(Thread.currentThread().getName() + " 结束.");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }

            Thread.sleep(2000);
            count.await();
            System.out.println("所有线程结束");
        }

}
