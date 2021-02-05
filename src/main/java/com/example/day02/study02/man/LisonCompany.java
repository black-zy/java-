package com.example.day02.study02.man;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LisonCompany implements InvocationHandler {
    private Object factory;

    public Object getFactory() {
        return factory;
    }

    public void setFactory(Object factory) {
        this.factory = factory;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(),factory.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomeThingBefore();
        Object ret = method.invoke(factory, args);
        doSomethingEnd();
        return ret;
    }

    private void doSomeThingBefore() {
        System.out.println("我是前置增强");
    }

    private void doSomethingEnd(){
        System.out.println("我是后置增强");
    }
}
