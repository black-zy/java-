package com.example.day01.study01.contorller;

import com.example.day01.study01.service.PreSon;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestConr {
    public static void main(String[] args) throws Exception {
        //1 返回与带有给定字符串名的类或接口相关联的 Class 对象。类加载器
        Class classTest = Class.forName("com.example.day01.study01.service.PreSon");
        //实例化对应的对象
//        Object object = classTest.newInstance();
        //强转类型
//        PreSon preSon = (PreSon) object;
        //设置属性值
//        preSon.setName("zhaoyu");
//        preSon.setAge("25");
//        Constructor constructor =  classTest.getConstructor(String.class,String.class);
//        Object object = constructor.newInstance("zhaoyu","26");
//        PreSon preSon = (PreSon) object;
//        System.out.println(preSon.toString());
//        Constructor[] constructors =classTest.getConstructors();
//        for (Constructor constructor : constructors) {
//            System.out.println(constructor);
//        }
        //Method method =classTest.getMethod("getAge");
//        method.invoke(classTest);
//        System.out.println(method);


        String b = new String("a") + new String("aa");
        b.intern();
        String a = "aaa";
        System.out.println(a==b);


    }
}
