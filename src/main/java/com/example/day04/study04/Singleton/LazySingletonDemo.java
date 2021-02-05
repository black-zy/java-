package com.example.day04.study04.Singleton;

/**
 * 懒汉单例模式
 */
public class LazySingletonDemo {
    /**
     * 可见性：可见性，是指线程之间的可见性，一个线程修改的状态对另一个线程是可见的。

       原子性：原子是世界上的最小单位，具有不可分割性。synchronized块之间的操作就具备原子性。volatile关键字定义的变量就可以做到这一点，Java还有两个关键字能实现可见性，即synchronized和final。

       有序性：如果在本线程内观察，所有的操作都是有序的：如果在一个线程中观察另外一个线程，所有的线程操作都是无序的。前半句是指“线程内表现为串行的语义”，后半句是指“指令重排序”现象和“工作内存与主内存同步延迟”现象。Java语言提供了volatile和synchronized两个关键字来保证线程之间操作的有序性

     volatile  能保证其可见性，不能保证原子性
     synchronized  能保证其可见性，也能保证原子性
     */
    private static volatile LazySingletonDemo instance= null;
    private LazySingletonDemo(){}
    public static synchronized LazySingletonDemo getInstance(){
        if (instance == null){
            instance = new LazySingletonDemo();
        }
        return instance;
    }

    void display(){
        System.out.println("22222");
    }


    public static void main(String[] args) {
        LazySingletonDemo.getInstance().display();
    }

}