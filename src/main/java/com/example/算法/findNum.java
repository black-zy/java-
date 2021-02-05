package com.example.算法;

/**
 * 需要准备的知识点：这也是一个技巧  对一个数取反;+1;然后在与运算本身可以得到最右边的一个1
 * a = 18        10010
 * ~a            01101
 * ~a +1         01110
 * a & ~a +1     00010
 *
 * 常见基础算法面试题
 * 一个数在一个数组中出现的次数是奇数个，其他的数出现的个数都是偶数个，怎么把奇数个的这个数找出来
 * [22,11,33,44,44,66,66,22,11]
 * 怎么把33找出来
 *
 *
 * 二个数在一个数组中出现的次数是奇数个，其他的都是偶数个，怎么把奇数个的这2个数找出来
 * 进阶版：[22,11,44,33,33,44,66,66,22,88]
 * 怎么把11，88找出来
 */
public class findNum {
    private static int[] arr = new int[]{22,11,44,33,33,44,66,66,22};
    private static int[] arr1 = new int[]{22,11,44,33,33,44,66,66,22,88};
    public static void main(String[] args) {
        test1(arr);
        test2(arr1);
    }

    public static void test1(int[] arr) {
        int ser = 0;
        for (int i=0;i<arr.length;i++){
            ser = ser ^ arr[i];
        }
        System.out.println(ser);
    }

    public static void test2(int[] arr) {
        int ser1 = 0;
        for (int i=0;i<arr.length;i++){
            ser1 = ser1 ^ arr[i];
        }
        //这2个值大于0；说明  a != b; 说明a 中有一位肯定和b 是不同的
        //获取这个数中最右边一个1 的位置
        int ser2 = ser1 & (~ser1 +1);
        int onlyOne= 0;
        for (int i=0;i<arr.length;i++){
            if((arr[i] & ser2) ==0 ){
                onlyOne = arr[i] ^ onlyOne;
            }
        }
        System.out.println("奇数第一个值："+onlyOne +" 第二个值："+ (ser1 ^ onlyOne));
    }
}
