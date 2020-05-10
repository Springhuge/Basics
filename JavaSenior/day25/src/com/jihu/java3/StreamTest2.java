package com.jihu.java3;

import com.jihu.java2.Employee;
import com.jihu.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 测试Stream的终止操作
 */
public class StreamTest2 {

    //1-匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //练习:是否所有的员工的年龄都大于18
        boolean allMatch = employees.stream().allMatch(employee -> employee.getAge() > 18);
        System.out.println(allMatch);

        //练习:是否存在员工资大于10000
        boolean anyMatch = employees.stream().anyMatch(employee -> employee.getSalary() > 10000);
        System.out.println(anyMatch);

        //练习:是否存在员工姓“雷”
        boolean noneMatch = employees.stream().noneMatch(employee -> employee.getName().startsWith("雷"));
        System.out.println(noneMatch);

        //返回第一个元素
        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println(employee);

        //返回当前流中的任意元素
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);
    }

    //2-规约
    @Test
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployees();
        //count   返回流中元素的总个数
        long count = employees.stream().filter(employee -> employee.getSalary() > 5000).count();
        System.out.println(count);

        //max 返回流中最大值
        //返回最高的工资
        Optional<Double> max = employees.stream().map(employee -> employee.getSalary()).max(Double::compare);
        System.out.println(max);

        //min 返回流中最小值
        //返回最低工资的员工
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);

        employees.stream().forEach(System.out::println);
    }

    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        //计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        //Double salarySum = employees.stream().map(Employee::getSalary).reduce((double) 0, Double::sum);
        Optional<Double> salarySum = employees.stream().map(Employee::getSalary).reduce((d1, d2) -> d1 + d2);
        System.out.println(salarySum);
    }

    //3-搜集
    @Test
    public void test4(){
        //练习1：查找工资大于6000的员工，结果返回一个list或set
        List<Employee> employees = EmployeeData.getEmployees();
        Set<Employee> collect = employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toSet());
        collect.forEach(System.out::println);

    }

}
