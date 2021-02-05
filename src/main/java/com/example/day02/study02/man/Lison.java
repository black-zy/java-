package com.example.day02.study02.man;

public class Lison implements SysFatory{


    public SysFatory fatory;

    public Lison(SysFatory fatory) {
        super();
        this.fatory = fatory;
    }

    @Override
    public void saleManTools(String size, String lenge) {
        fatory.saleManTools(size,lenge);
    }

    @Override
    public void saleManTools(String size) {
        doSomeThingBefore();
        fatory.saleManTools(size);
        doSomethingEnd();
    }

    private void doSomeThingBefore() {
        System.out.println("我是前置增强");
    }

    private void doSomethingEnd(){
        System.out.println("我是后置增强");
    }
}
