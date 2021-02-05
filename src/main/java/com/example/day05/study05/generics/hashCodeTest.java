package com.example.day05.study05.generics;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class hashCodeTest {
    Object student = new Object();

    public Object getStudent() {
        return student;
    }

    public void setStudent(Object student) {
        this.student = student;
    }
    public static void main(String[] args) {
        Object student = new Object();
        int i = student.hashCode();
        System.out.println(i);
        Date date = new Date();  // 对应的北京时间是2017-08-24 11:17:10
        //Thu, 19 Nov 2020 07:30:00 GMT+0800
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d M y HH:mm:ss zZ",Locale.US);     // 北京
        System.out.println(simpleDateFormat.format(date));


//        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
//        System.out.println(format.format(new Date()));
//        System.out.println(new Date(format.format(new Date())));
    }


}


