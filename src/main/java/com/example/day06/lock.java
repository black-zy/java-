package com.example.day06;


import java.util.concurrent.locks.ReentrantLock;

public class lock {
    static Object object = new Object();

    public static void main(String[] args) {

        System.out.println(Integer.toHexString(object.hashCode()));
        lockTest();
        lockTest();
    }
    public static void lockTest() {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        reentrantLock.unlock();
       synchronized (object ){
           System.out.println("test");
       }
        Thread thread = new Thread(){

            @Override
            public void run() {
                System.out.println("1111");
            }
        };
        thread.start();
        thread.yield();

    }
}
