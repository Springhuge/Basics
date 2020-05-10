package com.jihu.java3;

import com.jihu.java2.Employee;
import com.jihu.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1.Stream关注的是对数据的运算，与CPU打交道
 *      集合关注的是数据的存储，与内存打交道
 * 2.
 * ①Stream 自己不会存储元素
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 *
 * 3.Stream执行流程
 * ①Stream实例化
 * ②一系列的中间操作（过滤、映射）
 * ③终止操作
 *
 *
 * 4.说明
 * 4.1 一个中间操作链，对数据源的数据进行处理
 * 4.2 一旦执行终止操作，就执行中间操作链，并产生结果，不会再被使用
 *
 * 测试Stream的实例化
 *
 */
public class StreamAPITest {

    //创建Stream方式一：通过集合
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    //创建Stream方式二：通过数组
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(1002, "Jerry");
        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    //创建Stream方式三:通过Stream的of()
    @Test
    public void test3(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void test4(){

        //迭代
        //遍历前10个偶数
        Stream.iterate(0,t -> t + 2 ).limit(5).forEach(System.out::println);

        //生成
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }
}
