package com.example.day06;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/*
* Java中线程的状态分为6种。

1. 初始(NEW)：新创建了一个线程对象，但还没有调用start()方法。
2. 运行(RUNNABLE)：Java线程中将就绪（ready）和运行中（running）两种状态笼统的称为“运行”。
线程对象创建后，其他线程(比如main线程）调用了该对象的start()方法。该状态的线程位于可运行线程池中，等待被线程调度选中，获取CPU的使用权，此时处于就绪状态（ready）。就绪状态的线程在获得CPU时间片后变为运行中状态（running）。
3. 阻塞(BLOCKED)：表示线程阻塞于锁。
4. 等待(WAITING)：进入该状态的线程需要等待其他线程做出一些特定动作（通知或中断）。
5. 超时等待(TIMED_WAITING)：该状态不同于WAITING，它可以在指定的时间后自行返回。
6. 终止(TERMINATED)：表示该线程已经执行完毕。
*
* */
public class Thred1 implements Runnable{


    @Override
    public void run() {
        synchronized (this){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //this.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thred1 object = new Thred1();
        Thread thread1 = new Thread(object);
        Thread thread2 = new Thread(object);
        synchronized (thread1){
            try {
                System.out.println(Thread.currentThread().getName()+" start t1");
                thread1.start();
                System.out.println(Thread.currentThread().getName()+" wait()");
                thread1.wait();
                System.out.println(Thread.currentThread().getName()+" continue");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println(System.currentTimeMillis());
        thread1.start();

        System.out.println(System.currentTimeMillis());
        thread2.start();
        for(int j = 0;j < 50;j++)
        {
            System.out.println(Thread.currentThread().getName()+"..."+j);
        }
    }


//    public static void main(String[] args) throws InterruptedException {
//        //初始(NEW)：新创建了一个线程对象，但还没有调用start()方法。
//        //Thred1 t1 = new Thred1();
//        //2. 运行(RUNNABLE)：Java线程中将就绪（ready）和运行中（running）两种状态笼统的称为“运行”。
//        //线程对象创建后，其他线程(比如main线程）调用了该对象的start()方法。该状态的线程位于可运行线程池中，等待被线程调度选中，获取CPU的使用权，此时处于就绪状态（ready）。就绪状态的线程在获得CPU时间片后变为运行中状态（running）。
//        //new Thread(t1,"Thread").start();
//
//        //3. 阻塞状态
//        //阻塞状态是线程阻塞在进入synchronized关键字修饰的方法或代码块(获取锁)时的状态。
////        synchronized (t1){
////            System.out.println(111);
////        }
//        //4. 等待(WAITING)：进入该状态的线程需要等待其他线程做出一些特定动作（通知或中断）。
//        //处于这种状态的线程不会被分配CPU执行时间，它们要等待被显式地唤醒，否则会处于无限期等待的状态。
//        //需要配显示的唤醒，列入：park();  wait(); join()
//        Thread t12  = new Thread();
//        Thread t13  = new Thread();
//        new Thread(t12,"t12"){
//             @Override
//             public void run() {
//                 System.out.println("111");
//             }
//         }.join();
//        new Thread(t12,"t13"){
//            @Override
//            public void run() {
//                System.out.println("222");
//            }
//        }.start();
//
//        //5. 超时等待
//        //处于这种状态的线程不会被分配CPU执行时间，不过无须无限期等待被其他线程显示地唤醒，在达到一定时间后它们会自动唤醒。  sleep(time),wait(time),join(time),
//
//        //6. 终止状态
//        //当线程的run()方法完成时，或者主线程的main()方法完成时，我们就认为它终止了。这个线程对象也许是活的，但是，它已经不是一个单独执行的线程。线程一旦终止了，就不能复生。
//        //在一个终止的线程上调用start()方法，会抛出java.lang.IllegalThreadStateException异常。
//
//
//    }

//    @Override
//    public void run() {
//        System.out.println("当前线程："+Thread.currentThread().getName());
//    }


}
