package com.jihu.java;

/**
 * 一、枚举类的使用
 * 1.枚举类的理解：类的对象只有有限个，确定的，我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈简易使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式
 *
 *
 * 二、如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0，可以使用enum关键字定义枚举类
 *
 * 三、Enum类中的常用方法
 *
 * 四、使用enum关键字定义的枚举类实现接口的情况
 *  情况一；实现接口，在enum类中实现抽象方法
 *  情况二：让枚举类对象分别实现接口中的抽象方法
 *
 */
public class SeasonTest {

    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);

        System.out.println("******************************");
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        //valueOf(String ObjName)
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        winter.show();
    }

}

