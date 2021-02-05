package com.example.day03.study03.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出
 * java.lang.OutOfMemoryError: Java heap space
 */
public class DemoHeap {
//    public static void main(String[] args) {
//        List<String> lists = new ArrayList<String>();
//        int i=0;
//        String a = "helloWorld";
//        try{
//            while (true){
//                a=a+a;
//                lists.add(a);
//                i++;
//            }
//        }catch (Throwable e){
//            e.printStackTrace();
//            System.out.println(i);
//        }
//    }

    public static void main(String[] args) {
        try {
            System.out.println("1....");
            byte[] bytes = new byte[1024*1024*10];
            Thread.sleep(20000);
            System.out.println("2....");
            bytes = null;
            System.gc();
            Thread.sleep(30000);
            System.out.println("3....");

        }catch (Throwable e){
            e.printStackTrace();
        }
    }

}
