package com.jihu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 *
 * 1.举例：(o1,o2) -> Integer.compare(o1,o2)
 * 2.格式：
 *       ->Lambda操作符 或者 箭头操作符
 *       ->左边:lambda形参列表 (其实就是接口中的抽象方法的形参列表)
 *       ->右边:lambda体(其实就是重写的抽象方法的方法体)
 * 3.Lambda表达式的使用：(分为6中情况介绍)
 *      总结：
 *      ->左边：Lambda形参列表类型可以省略(类型推断) 如果Lambda形参列表只有一个参数，其一对()也可以
 *      ->右边：lambda体应该使用一对{}包裹，如果Lambda只有一条执行语句（可能时return语句） 省略这一个{} 和return
 *
 *
 * 4.Lambda表达式的本质:作为函数式接口的实例
 *
 * 5.如果一个接口中，只声明了一个接口，则此接口就称为函数式接口
 */
public class LambdaTest1 {

    //语法格式一：无参，无返回值
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();

        System.out.println("*****************************");

        Runnable r2 = ()-> System.out.println("我爱北京故宫");
        r2.run();
    }

    //语法格式二：Lambda 需要一个参数，但是没有返回值
    @Test
    public void test2(){
        Consumer<String> com = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        com.accept("谎言和誓言的区别是什么?");

        System.out.println("*****************************");

        Consumer<String> com2 = (String s) -> {
            System.out.println(s);
        };
        com2.accept("一个是听的人当真了，一个是说的人当真了");
    }

    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为类型推断
    @Test
    public void test3(){
        Consumer<String> com = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        com.accept("谎言和誓言的区别是什么?");

        System.out.println("*****************************");

        Consumer<String> com2 = (s) -> {
            System.out.println(s);
        };
        com2.accept("一个是听的人当真了，一个是说的人当真了");
    }

    @Test
    public void test4(){
        ArrayList<String> list = new ArrayList<>(); //类型推断

        int[] arr = {1,2,3}; //类型推断
    }

    //语法格式四：Lambda若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test5(){
        Consumer<String> com1= (s) -> {
            System.out.println(s);
        };
        com1.accept("一个是听的人当真了，一个是说的人当真了");

        System.out.println("*****************************");

        Consumer<String> com2= s -> {
            System.out.println(s);
        };
        com1.accept("一个是听的人当真了，一个是说的人当真了");
    }

    //语法格式五：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test6(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println(com1.compare(12, 21));

        System.out.println("*****************************");

        Comparator<Integer> com2 = (o1,o2)->{
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12, 21));
    }

    //语法格式六：当Lambda体只有一条语句时，return与大括号 若有，都可以省略
    @Test
    public void test7(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println(com1.compare(12, 21));

        System.out.println("*****************************");

        Comparator<Integer> com2 = (o1,o2)-> o1.compareTo(o2);
        System.out.println(com2.compare(12, 21));
    }

    @Test
    public void test8(){
        Consumer<String> com1= s -> {
            System.out.println(s);
        };
        com1.accept("一个是听的人当真了，一个是说的人当真了");


        System.out.println("*****************************");

        Consumer<String> com2= s -> System.out.println(s);
        com2.accept("一个是听的人当真了，一个是说的人当真了");

    }

}
