package com.example.day03.study03.functionDemo;

public class functionDemo extends ClassLoader{
    public static void main(String[] args) {
        String a = new String("1");
        a.intern();
        String b = "1";
        System.out.println(b == a);

//        String d = new String("1") + new String("1");
//        d.intern();
//        String f= "11";
//        System.out.println( d==f );
    }

}
