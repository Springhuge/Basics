package com.jihu.exer1;

import org.junit.Test;

import java.util.*;

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

                //比较年
                int minsYear = b1.getYear() - b2.getYear();
                if(minsYear != 0){
                    return minsYear;
                }

                //比较月
                int minsMonth = b1.getMonth() - b2.getMonth();
                if(minsMonth != 0){
                    return minsMonth;
                }

                //比较日
                int minsDay = b1.getDay() - b2.getDay();
                if(minsDay != 0){
                    return minsDay;
                }
                return 0;
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

    public static List duplicateList(List list){
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }

    @Test
    public void test3(){
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        list2.forEach(System.out::println);
    }

    @Test
    public void test4(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);
        set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001,"CC"));
        System.out.println(set);
        set.add(new Person(1001,"AA"));
        System.out.println(set);
    }
}