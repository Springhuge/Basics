package com.jihu.java3;

import com.jihu.java2.Employee;
import com.jihu.java2.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 */
public class StreamAPITest1 {

    //1.筛选和切片
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        employees.stream().filter( employee -> employee.getSalary() > 7000).forEach(System.out::println);

        System.out.println("**********************************************************");

        employees.stream().limit(3).forEach(System.out::println);

        System.out.println("**********************************************************");

        employees.stream().skip(3).forEach(System.out::println);

        System.out.println("**********************************************************");

        employees.add(new Employee(1001,"马化腾",34,6000.38));
        employees.stream().forEach(System.out::println);
        System.out.println("**********************************************************");
        employees.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2(){
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        //练习一：获取员工姓名长度大于3的员工的姓名
        List<Employee> employees = EmployeeData.getEmployees();

        List<String> collect = employees.stream().filter(employee -> employee.getName().length() > 3).map(employee -> {
            return employee.getName();
        }).collect(Collectors.toList());
        System.out.println(collect);

        System.out.println();

        //练习二：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s ->{
            s.forEach(System.out::println);
        });


    }

    //将字符串中的多个字符构成集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3(){
        ArrayList<Object> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Integer> list2= new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        list1.addAll(list2);
        System.out.println(list1);
    }

    //排序
    @Test
    public void test4(){
        //sorted()——自然排序
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list.stream().sorted().forEach(System.out::println);

        //抛异常，原因：Employee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com)——定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2) ->{
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if(ageValue != 0){
                return ageValue;
            }else {
                return Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);
    }

}
