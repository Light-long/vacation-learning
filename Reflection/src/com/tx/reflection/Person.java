package com.tx.reflection;

public class Person {

    private String name;
    public int age;

    public Person() {}
    private Person(String name) {
        this.name = name;
    }
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    // getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show() {
        System.out.println("I am a Person");
    }

    private String showNation(String nation) {
        System.out.println("我的国籍是"+nation);
        return nation;
    }

    private static void info() {
        System.out.println("我是一个好人");
    }
}
