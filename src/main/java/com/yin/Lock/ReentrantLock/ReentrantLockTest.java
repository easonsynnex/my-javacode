package com.yin.Lock.ReentrantLock;


import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by easony on 06/13/18.
 */
public class ReentrantLockTest {
    static class Service {
        ReentrantLock reentrantLock = new ReentrantLock();

        void doSomething(){
            reentrantLock.lock();
            try{
                for (int i=0;i<3;i++)
                    System.out.println(Thread.currentThread().getName()+" -> "+ i);
            }finally {
                //必须手动释放锁
                reentrantLock.unlock();
            }

        }
    }

    static class myThread extends Thread {
        Service service;
        public myThread(Service service){
            this.service = service;
        }
        @Override
        public void run() {
            service.doSomething();
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        Thread[] threads = new Thread[5];
        for (int i = 0;i < 5;i++){
            threads[i]=new myThread(service);
        }
        for (int i = 0;i < 5;i++){
            threads[i].start();
        }
    }
}
