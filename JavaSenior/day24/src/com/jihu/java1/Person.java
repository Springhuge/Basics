package com.jihu.java1;

@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private static final long serialVersionUID = 6505480477959991685L;

    private String name;
    int age;
    public int id;

    public Person(){}

    @MyAnnotation(value = "abc")
    private Person(String name){
        this.name = name;
    }

    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String display(String insterests,int age) throws NullPointerException,ClassCastException{
        return insterests + age;
    }

    @MyAnnotation
    public String show(String nation){
        System.out.println("我的国籍是："+nation);
        return nation;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String nation) {

        return 0;
    }

    public static void showDesc(){
        System.out.println("我是一个可爱的人");
    }
}
