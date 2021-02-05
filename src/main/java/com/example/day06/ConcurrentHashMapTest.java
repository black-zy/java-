package com.example.day06;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
//    public static void main(String[] args) {
//        ConcurrentHashMap<String,String> concurrent = new ConcurrentHashMap();
//        concurrent.put("1","2");
//
//        Hashtable hashtable = new Hashtable();
//    }

    static final int resizeStamp(int n) {
        int zeroCount = Integer.numberOfLeadingZeros(n);
        System.out.println(zeroCount);
        return Integer.numberOfLeadingZeros(n) | (1 << (RESIZE_STAMP_BITS - 1));
    }
    private static int RESIZE_STAMP_BITS = 16;

    private static final int RESIZE_STAMP_SHIFT = 32 - RESIZE_STAMP_BITS;
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrent = new ConcurrentHashMap();
        concurrent.put("1","2");

        Hashtable hashtable = new Hashtable();
        // <0 时溢出，结束
        for(int n=1;n>0;n*=2){
            int rs = resizeStamp(n);
            int ans = (rs << RESIZE_STAMP_SHIFT) + 2;
            System.out.println("n:"+n+"    rs:"+rs+"  ans:"+ans);
        }
    }


}
