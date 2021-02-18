package com.example.day07.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * CAS  是什么？
 * 个人理解是一种期望修改，是unsafe方法下的一个操作
 * 比较并交换
 */
public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.compareAndSet(5, 2021)+"修改后的值是:"+atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 1024)+"修改后的值是:"+atomicInteger.get());
    }
}
