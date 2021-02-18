package com.example.day07.siingle;

/**
 * DCL（双端检索）机制不一定线程安全，原因是有指令重排序的存在，加入volatile可以禁止指令重排
 *
 */
public class singleton {
    private static volatile singleton instance = null;
    private singleton(){
        System.out.println("我是线程"+Thread.currentThread().getName());
    }
    /**
     * 锁同步代码块
     */
    private static singleton getInstance(){
        if(instance == null){
            synchronized (singleton.class){
                if(instance == null){
                    instance = new singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                singleton.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
