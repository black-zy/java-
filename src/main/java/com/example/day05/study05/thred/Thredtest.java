package com.example.day05.study05.thred;

public class Thredtest {

    private String a;

    public static void main(String[] args) {
        new Thread(()->{
            Thredtest thredtest = new Thredtest();
            thredtest.fun1();
        }).start();

        new Thread(()->{
            Thredtest thredtest = new Thredtest();
            thredtest.fun2();
        }).start();

    }

    public void fun1(){
        System.out.println("fun1"+a);
    }

    public void fun2(){
        System.out.println("fun2"+a);
    }
}
