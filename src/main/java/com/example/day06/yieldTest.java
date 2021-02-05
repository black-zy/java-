package com.example.day06;

public class yieldTest extends Thread {
    private String name;
    public yieldTest(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 50; i++) {
            if(i==30){
                System.out.println(name  + ":" + i +"......yield.............");
                this.yield();
            }
            System.out.println(name+":"+i);
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new yieldTest("t1"));
        Thread t2 = new Thread(new yieldTest("t2"));
        t1.start();
        t2.start();
    }
}
