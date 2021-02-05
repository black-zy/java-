package com.example.算法;

import java.util.Arrays;

/**
 * 选择排序算法
 * 1  时间复杂度  O(n^2)
 * 时间复杂度：是常数项操作的次数
 * 基础知识点：
 *    [2,3,4,5,72,1,34,6,7,2,3544]
 *    /随机找一个数，然后从小到大排序，或者从大到小排序
 *    在一个数组中从第一位开始找依次对比数组中其他的数，如果比它小则交换
 *    掌握知识点：^ 异或运算(支持交换律和结合律)  相同为0，不同为1
 *    交换律:a ^ b = b ^ a
 *    结合律:a ^ b ^ c = a ^ (b ^ c)
 *    特殊： a ^ 0 = a
 *    a= a ^ b;
 *    b= a ^ b;  //  b = a ^ b ^ b  =a
 *    a= a ^ b;  //  a = a ^ b ^ a  =b
 *    经过这3次运算，a 和 b 的值就会交换，交换的前提（不在一个内存空间，否则异或本身会变成0）
 */
public class xuanZhePaixu {
    private static int[] arr = new int[]{2, 3, 4, 5, 72, 1, 34, 6, 7, 2, 3544};
    public static void main(String[] args) {
        for (int i = 0;i<arr.length-1;i++){
            for (int j = 0;j<arr.length-i-1;j++){
                if(arr[j] < arr[i]){
                    swap(arr,i,j);
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
