package com.example.day02.study02;

import com.example.day02.study02.man.AaFatory;
import com.example.day02.study02.man.Lison;
import com.example.day02.study02.man.LisonCompany;
import com.example.day02.study02.man.SysFatory;

public class zhangsan {

    public static void main(String[] args) {
//        SysFatory fatory = new AaFatory();
//        Lison lison = new Lison(fatory);
//        lison.saleManTools("D");

        SysFatory sysFatory = new AaFatory();
        LisonCompany lisonCompany = new LisonCompany();
        lisonCompany.setFactory(sysFatory);
        SysFatory lison1 = (SysFatory) lisonCompany.getProxyInstance();
        lison1.saleManTools("D");





    }
}
