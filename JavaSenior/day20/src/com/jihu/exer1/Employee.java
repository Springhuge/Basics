package com.jihu.exer1;

/**
 * 定义一个Employee类。
 *
 * 该类包含：private 成员变量 name，age，birthday，其中birthday为MyDate类的对象。
 *
 * 并为每一个属性定义getter，setter方法
 *
 * 并重写toString方法输出name，age，birthday
 */
public class Employee implements Comparable{

    private String name;
    private int age;
    private MyDate myDate;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", myDate=" + myDate +
                '}';
    }

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

    public MyDate getMyDate() {
        return myDate;
    }

    public void setMyDate(MyDate myDate) {
        this.myDate = myDate;
    }

    public Employee(String name, int age, MyDate myDate) {
        this.name = name;
        this.age = age;
        this.myDate = myDate;
    }

    public Employee() {

    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee e = (Employee) o;
            return this.name.compareTo(e.name);
        }
        //return 0;
        throw  new RuntimeException("传入的数据类型不一致");
    }
}
