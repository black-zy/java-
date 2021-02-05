package com.example.day06;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class parkTest extends Thread{
    @Override
    public void run() {
        for (int i =0;i<50;i++){
            if(i ==10){
                try {
                    Thread.sleep(500);
                    System.out.println(System.currentTimeMillis()+"线程等待"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(500));
//                System.out.println(System.currentTimeMillis()+"线程等待"+Thread.currentThread().getName()+"+"+i);
            }else {
                System.out.println(System.currentTimeMillis()+"线程"+Thread.currentThread().getName()+"+"+i);
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
//        parkTest p = new parkTest();
//        Thread t1 = new Thread(p,"t1");
//        Thread t2 = new Thread(p,"t2");
//        t1.start();
//        t2.start();
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis()/1000L);
        Thread.sleep(500);
        System.out.println(System.currentTimeMillis()/1000L);
    }
}
