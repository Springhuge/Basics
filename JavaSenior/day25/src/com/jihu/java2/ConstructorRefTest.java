package com.jihu.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorRefTest {

    @Test
    public void test1(){

        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };

        System.out.println(sup.get());

        System.out.println("************************");

        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println(sup1.get());

    }

    @Test
    public void test2(){
        Function<Integer,Employee> fun1 = id -> new Employee(id);
        Employee employee = fun1.apply(1001);
        System.out.println(employee);

        System.out.println("************************");

        Function<Integer,Employee> fun2 =Employee::new;
        Employee employee2 = fun2.apply(1002);
        System.out.println(employee2);
    }

    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> fun1 =  (id,name) -> new Employee(id,name);
        System.out.println(fun1.apply(1001,"Tom"));

        System.out.println("*******************************");

        BiFunction<Integer,String,Employee> fun2 = Employee::new;
        System.out.println(fun2.apply(1002,"Jerry"));
    }

    @Test
    public void test4(){
        Function<Integer,String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println("************************");

        Function<Integer,String[]> func2 = String[] :: new;
        String[] arr2 = func2.apply(10);
        System.out.println(Arrays.toString(arr2));
    }
}
