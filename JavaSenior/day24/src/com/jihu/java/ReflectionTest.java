package com.jihu.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

    //反射之前，对Person的操作
    @Test
    public void test1(){

        //1.创建Person类的对象
        Person p1 = new Person("Tom",12);

        //2.通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        //在Person类外部，不可以通过Person类的对象调用其内部私有结构
        //比如：name、showNation()以及私有构造器
    }

    //反射之后，对于Person的操作
    @Test
    public void test2() throws Exception{
        Class<Person> clazz = Person.class;
        Constructor<Person>  constructor = clazz.getConstructor(String.class,int.class);

        Person person  = constructor.newInstance("Tom",12);
        System.out.println(person.toString());

        //2.通过反射，调用对象指定的属性、方法
        //调属性
        Field age = clazz.getDeclaredField("age");
        age.set(person,10);
        System.out.println(person.toString());

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);

        //通过反射，可以调用Person类的私有结构的 比如 私有的构造器 方法 参数
        //调用私有的构造器
        Constructor<Person> constructor1 = clazz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person person1 = constructor1.newInstance("Jerry");
        System.out.println(person1);

        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person1,"HanMeimei");
        System.out.println(person1);

        //调用是由的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(person1,"中国");//相当于person1.showNation("中国")
        System.out.println(nation);
    }

    //疑问？通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用哪个？
    //建议：直接new的方式
    //什么时候会使用 反射的方式 反射的特征 动态性
    //疑问？反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
    //不矛盾，
    /**
     * 关于java.lang.Class类的理解
     * 1.类的加载过程
     *  程序在经过java.c命令以后，会生成一个或多个字节码文件(.class后缀),接着我们使用
     *  java.exe命令对某个字节码文件进行解释运行 相当于将某个字节码文件加载到内存中 此
     *  过程称为类的加载。加载在内存中的类，我们就称为运行时类，此运行时类，就作为Class
     *  的一个实例
     * 2.换句话说，Class的实例就对应着一个运行时类
     * 3.加载在内存中的运行时类，会缓存一定的时间，在此时间之内，我们可以通过不同的方式
     * 来获取此运行时类
     *
     */

    /**
     * 获取Class的实例方式（前三种方式需要掌握）
     */
    @Test
    public void tsst3() throws ClassNotFoundException {
        //方式一 调用运行时类的属性 .class
        Class<Person> class1 = Person.class;
        System.out.println(class1);

        //方式二 通过运行时类的对象
        Person person = new Person();
        Class class2 = person.getClass();
        System.out.println(class2);

        //方式三 调用Class的静态方法：forName(String classPath)
        Class class3 = Class.forName("com.jihu.java.Person");
        System.out.println(class3);

        System.out.println(class1 == class2);
        System.out.println(class1 == class3);

        //方式四：使用类加载器 ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class class4 = classLoader.loadClass("com.jihu.java.Person");
        System.out.println(class3);
        System.out.println(class1 == class4);


    }

    //万事万物皆对象


    //Class实例可以是哪些结构的说明
    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        //只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }

}
