package com.example.day04.study04.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 */

public class ObserverTest {

    public static void main(String[] args) {

        Subject subject = new Subject();
        subject.addObserver(new Task1());
        subject.addObserver(new Task2());
        subject.notifyObserver("xxxxxx");

    }
}

class Subject{
    private List<Observer> container = new ArrayList<>();

    public void addObserver(Observer observer){
        container.add(observer);
    }

    public void remover(Observer observer){
        container.remove(observer);
    }

    public void notifyObserver(Object object){
        for (Observer item : container){
            item.update( object );
        }
    }


}


interface Observer{
    void update(Object object);
}

class Task1 implements Observer{
    @Override
    public void update(Object object) {
        System.out.println("received:"+object);
    }
}

class Task2 implements Observer{
    @Override
    public void update(Object object) {
        System.out.println("task2 received:"+object);
    }
}