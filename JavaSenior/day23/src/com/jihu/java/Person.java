package com.jihu.java;

import java.io.Serializable;

/**
 * Person需满足以下要求，方可序列化
 * 1.需要实现接口Serializable
 * 2.需要当前类提供一个全局常量：serialVersionUID
 * 3.除了当前Person类需要实现SerialVersionUID接口之外，还必须保证内部所有属性
 *  也必须是课序列化的。默认情况下，基本数据类型可序列化
 *
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -6788400976003350116L;

    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {

        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
