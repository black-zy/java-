package com.example.day05.study05.Lambda;

public class LambdaTest {

    interface Printer{
        void printer(String val);
    }
    public void pringSomething(String something,Printer printer){
        printer.printer(something);
    }

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        String add = "dadasdasd";
//        Printer printer = new Printer() {
//            @Override
//            public void printer(String val) {
//                System.out.println(val);
//            }
//        };
        Printer printer = (String val)->{
            System.out.println(val);
        };
        Printer printer1 = val -> System.out.println(val);
        lambdaTest.pringSomething(add,val -> System.out.println(val));

    }
}
