package com.example.day05.study05.Array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {
//    public static void main(String[] args) {
//        int sum =0;
//        Scanner scanner = new Scanner(System.in);
//        for(int i=1;i<=10;i++){
//            System.out.println("请录入第"+i+"个学生的成绩：");
//            int score = scanner.nextInt();
//            sum += score;
//        }
//        System.out.println("十个学生的成绩之和为："+sum);
//        System.out.println("十个学生的成绩平均数为:"+sum/10);
//    }

//    public static void main(String[] args) {
//        int[] score = new int[10];
//        int sum =0;
//        Scanner scanner = new Scanner(System.in);
//        for(int i=1;i<=10;i++){
//            System.out.println("请录入第"+i+"个学生的成绩：");
//            score[i-1] = scanner.nextInt();
//            sum += score[i-1];
//        }
//        System.out.println("十个学生的成绩之和为："+sum);
//        System.out.println("十个学生的成绩平均数为:"+sum/10);
//
//        /**
//         * 增强for循环
//         */
//        for (int num :score){
//            System.out.println("十个同学的学生成绩为:"+num);
//        }
//    }

//    public static void main(String[] args) {
//        int[] arr ={12,3,4,56,8,9,12,121,122,222,1111,111124,222};
//        int maxNum = arr[0];
//        for (int a=0;a<arr.length;a++){
//            int num = arr[a];
//            if(num > maxNum){
//                maxNum = num;
//            }
//        }
//        System.out.println("当前数组中最大值为:"+maxNum);
//    }
//    /**
//     * 给定数组中在指定位置添加元素
//     * int[] arr = {2,12,3,56,22,111,111123,3434343};
//     * int[3]  = arr[4];
//     * int[4]  = arr[5];
//     */
//    public static void main(String[] args) {
//        int[] arr = {2,12,3,56,22,111,111123,3434343};
//        int index = 2;
//        for (int i=index;i<arr.length;i++){
//            arr[i] = arr[i+1];
//        }
//        System.out.println(arr);
//    }

//    public static void main(String[] args) {
//        int[] arr = {2,12,3,56,22,111,111123,3434343};
//        Arrays.sort(arr);
//        System.out.println(Arrays.binarySearch(arr,56));
//    }

    public static void main(String[] args) {
        int[][] arr =  new int[3][];
        int[] a1 = {1,2,3};
        int[] a2 = {1,2,3,4,56,7};
        int[] a3 = {31,22,23};
        arr[0] = a1;
        arr[1] = a2;
        arr[2] = a3;
        System.out.println(Arrays.toString(arr[0]));
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                System.out.println(arr[i][j]);
            }
            System.out.println();
        }
    }

}
