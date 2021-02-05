package com.example.day04.study04.Chain;

public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        Handler concreteHandler1 = new ConcreteHandler1();
        Handler concreteHandler2 = new ConcreteHandler2();
        concreteHandler1.setNext(concreteHandler2);
        concreteHandler1.handleRequest("two");
    }

}

abstract class Handler{
    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handleRequest(String request);
}

class ConcreteHandler1 extends Handler{

    @Override
    public void handleRequest(String request) {
        if(request.equals("one")){
            System.out.println("具体处理者1负责处理该请求");
        }else{
            if (getNext() != null){
                getNext().handleRequest(request);
            }else{
                System.out.println("没人处理该请求");
            }
        }
    }
}
//具体处理者角色2
class ConcreteHandler2 extends Handler
{
    public void handleRequest(String request)
    {
        if(request.equals("two"))
        {
            System.out.println("具体处理者2负责处理该请求！");
        }
        else
        {
            if(getNext()!=null)
            {
                getNext().handleRequest(request);
            }
            else
            {
                System.out.println("没有人处理该请求！");
            }
        }
    }
}