package com.example.day02.study02.man;

public class AaFatory implements SysFatory{

    @Override
    public void saleManTools(String size, String lenge) {

    }

    @Override
    public void saleManTools(String size) {
        System.out.println("您购买了一个size为:"+size+"的女模特");
    }
}
