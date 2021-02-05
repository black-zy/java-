package com.example.day01.study01.service;

public class PreSon {
    private String name;
    private String age;

    @Override
    public String toString() {
        return "PreSon{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public PreSon(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public PreSon() {
    }

    private PreSon(String name){

    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String find() {
        return age;
    }

}
