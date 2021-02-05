package com.example.day04.study04.Singleton;

public class HungrySingleton {
    private static final HungrySingleton instance=new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance()
    {
        return instance;
    }

    void display(){
        System.out.println("333333");
    }

    public static void main(String[] args) {
        HungrySingleton.getInstance().display();
    }
}
