package com.jihu.java2;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * 1.使用情境：当要传递给Lambda体的操作，已经由实现的方法了，可以使用方法引用
 *
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的示列，所以
 *   方法引用，也是函数接口的实例
 *
 * 3.使用格式：类（或对象） :: 方法名
 *
 * 4.具体分为如下三种情况：
 *      对象::非静态方法
 *      类::静态方法
 *
 *      类::非静态方法
 *
 * 5.方法引用使用的要求，要求接口中的抽象方法的形参列表和返回值类型与引用的方法的
 *  新参列表和返回值相同！
 *
 */
public class MethodRefTest {

    @Test
    public void test1(){
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");

        System.out.println("***********************");

        Consumer<String> con2 = System.out::println;
        con2.accept("beijing");
    }

    @Test
    public void test2(){
        Employee employee = new Employee(1001,"Tom",23,5600);
        Supplier<String> sup1 = () -> employee.getName();
        System.out.println(sup1.get());

        System.out.println("***********************");
        Supplier<String> sup2 = employee::getName;
        System.out.println(sup2.get());
    }

    @Test
    public void test3(){
        Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1,t2);
        System.out.println(com1.compare(12,21));

        System.out.println("***********************");

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(12,21));
    }

    @Test
    public void test4(){
        Function<Double,Long> fun1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };
        System.out.println(fun1.apply(12.3));

        System.out.println("***********************");

        Function<Double,Long> fun2 = d -> Math.round(d);
        System.out.println(fun2.apply(12.3));

        System.out.println("***********************");

        Function<Double,Long> fun3 = Math::round;
        System.out.println(fun3.apply(12.3));
    }

    @Test
    public void test5(){
        Comparator<String> com1 = (s1,s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "abd"));

        System.out.println("********************************");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abc", "abd"));
    }

    @Test
    public void test6(){
        BiPredicate<String,String> predicate1 = (s1,s2) -> s1.equalsIgnoreCase(s2);
        System.out.println(predicate1.test("abc","abc"));

        System.out.println("********************************");

        BiPredicate<String,String>  predicate2= String::equals;
        System.out.println(predicate2.test("abc","abc"));
    }

    @Test
    public void test7(){
        Employee employee = new Employee(1001,"Tom",23,5600);

        Function<Employee,String> function = e -> employee.getName();
        System.out.println(function.apply(employee));

        System.out.println("********************************");

        Function<Employee,String> function1 = Employee::getName;
        System.out.println(function1.apply(employee));
    }
}
