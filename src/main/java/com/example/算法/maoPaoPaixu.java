package com.example.算法;

import java.util.Arrays;

/**
 * 冒泡排序算法
 * 1  时间复杂度  O(n^2)
 * 时间复杂度：是常数项操作的次数
 * 基础知识点：
 *    [1111,3,4,5,72,1,34,6,7,2,3544]
 *    冒泡排序：第一位和第二位对比，如果比它大则不用动，如果比它小这向右移动
 *    掌握知识点：^ 异或运算(支持交换律和结合律)  相同为0，不同为1
 *    交换律:a ^ b = b ^ a
 *    结合律:a ^ b ^ c = a ^ (b ^ c)
 *    特殊： a ^ 0 = a, a ^ a = 0
 *    a= a ^ b;
 *    b= a ^ b;  //  b = a ^ b ^ b  =a
 *    a= a ^ b;  //  a = a ^ b ^ a  =b
 *    经过这3次运算，a 和 b 的值就会交换，
 *    交换的前提:不在一个内存空间，否则异或本身会变成0
 *    *     [2,3,4,5,72,1,34,6,7,2,3544]
 *  *    第一次： 2  3---------> 2,3  n
 *  *    第二次： 2  3  4---------> 2,3,4 n-1
 *  *    第三次： 2  3  4  5---------> 2,3,4,5 n-2
 *
 */
public class maoPaoPaixu {
    private static int[] arr = new int[]{1111,3,4,5,72,1,34,6,7,2,3544};
    public static void main(String[] args) {
        for (int i =0;i<arr.length-1;i++){
            for (int j = 0; j<arr.length-i-1;j++){
                if(arr[j] < arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
