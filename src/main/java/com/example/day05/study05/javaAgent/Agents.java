package com.example.day05.study05.javaAgent;

import javassist.*;

import java.lang.instrument.Instrumentation;

public class Agents {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
        ClassPool pool = new ClassPool(true);
        //插入类路劲，通过类路劲去搜索我们要的类
        pool.insertClassPath(new LoaderClassPath(Agents.class.getClassLoader()));

        CtClass targetClass = pool.makeClass("com.example.day05.study05.javaAgent");
        targetClass.addInterface(pool.get(Hello.class.getName()));
        CtClass returnType = pool.get(void.class.getName());
        String name = "syaHello";
        CtClass[] paramters = new CtClass[]{pool.get(String.class.getName())};
        CtMethod method = new CtMethod(returnType, name, paramters, targetClass);
        String src = "{"
                + "System.out.println(\"hello\" + $1);"
                +"}";
        method.setBody(src);
        targetClass.addMethod(method);
        Class aClass = targetClass.toClass();
        Hello hello = (Hello) aClass.newInstance();
        hello.syaHello("小灰灰");
    }
    public interface Hello{
        public void syaHello(String name);
    }

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("hello premain");
    }
}
