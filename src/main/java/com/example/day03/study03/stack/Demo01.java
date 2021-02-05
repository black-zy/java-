package com.example.day03.study03.stack;

//虚拟机栈内存溢出演示
public class Demo01 {
    static int count = 0;
    public static void main(String[] args) {
        try {
            sayHello();
        }catch (Exception e){
            System.out.println(count);
            e.printStackTrace();
        }


    }

    static void sayHello(){
        count++;
        sayHello();
    }
}
