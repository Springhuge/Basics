package com.jihu.exer1;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 创建该类的5个对象，并把这些对象放入TreeSet集合中（下一章：TreeSet需使用泛型来定义）
 *
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出
 *
 * 1.使Employee实现COmparable接口，并按name排序
 *
 * 2.创建TreeSet时传入Comparator对象，按生日日期的先后排序
 */
public class EmployeeTest {

    //问题一：使用自然排序
    @Test
    public void test1(){
        Set set = new TreeSet();
        Employee e1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("zhangxueyou",43,new MyDate(1987,5,4));
        Employee e3 = new Employee("guofucheng",44,new MyDate(1954,5,9));
        Employee e4 = new Employee("liming",51,new MyDate(1978,8,12));
        Employee e5 = new Employee("liangzhaowei",21,new MyDate(1978,12,4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //问题二:
    @Test
    public void test2(){
        Set set = new TreeSet((Object o1,Object o2)->{
            if(o1 instanceof Employee && o2 instanceof Employee){
                Employee e1 = (Employee) o1;
                Employee e2 = (Employee) o2;

                MyDate b1 = e1.getMyDate();
                MyDate b2 = e2.getMyDate();

                int minsYear = b1.getYear() - b2.getYear();
                if(minsYear != 0){
                    return minsYear;
                }

                int minsMonth = b1.getMonth() - b2.getMonth();
                if(minsMonth != 0){
                    return minsMonth;
                }

                int minsDay = b1.getDay() - b2.getDay();
                if(minsDay != 0){
                    return minsDay;
                }
            }
            throw new RuntimeException("传入的数据类型不一致");
        });
        Employee e1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("zhangxueyou",43,new MyDate(1987,5,4));
        Employee e3 = new Employee("guofucheng",44,new MyDate(1954,5,9));
        Employee e4 = new Employee("liming",51,new MyDate(1978,8,12));
        Employee e5 = new Employee("liangzhaowei",21,new MyDate(1978,12,4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
