package com.jihu.java2;

import org.junit.Test;

import java.util.*;

/**
 * 一、集合框架的概述
 *
 * 1.集合、数组都是对多个数字进行存储操作的结构，简称java容器
 *      说明：此时的存储，只要指的是内存层面的存储，不涉及到持久化的存储(.txt .jpg .avi 数据库中)
 *
 * 2.1数组在存储多个数据方面的特点
 *      >一旦初始化以后，其长度就确定了。
 *      >数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *          比如：String[] arr;int[] arr1;
 * 2.2 数组在存储多个数据方面缺点：
 *      >一旦初始化之后，其长度就不可修改
 *      >数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便
 *      >获取数组中实际元素的个数的需求，数据没有现成的属性或方法可用
 *      >数据存储数据的特点：有序 、可重复。对于无序、不可重复的需求，不能满足
 *
 * 二、集合框架
 *      |---Collection接口:单列集合，用来存储一个一个的对象
 *          |---List接口:存储有序的、可重复的数据 -->动态数组
 *              |---ArrayList、LinkedList、Vector
 *          |---Set接口:存储无序的、不可重复的数据 -->高中讲的“集合”
 *              |---HashSet、LinkedHashSet、TreeSet
 *      |---Map接口:双列集合，用来存储(key-value)一对一对的数据  -->高中函数:y = f(x)
 *              |---HashMap、LinkedHashMap、TreeMap、HashTable、Properties
 *
 *      Collection接口中的方法使用
 *
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection collection = new ArrayList();

        //add(Object e)
        collection.add("AA");
        collection.add("BB");
        collection.add(123);//自动装箱
        collection.add(new Date());

        System.out.println(collection.size()); //4

        //addAll() //将collection2集合中元素添加到当前的集合中
        Collection collection2 = new ArrayList();
        collection2.add(456);
        collection2.add("CC");
        collection.addAll(collection2);

        System.out.println(collection.size());

        System.out.println(collection);

        //clear():清空集合元素
        collection.clear();

        //isEmpty():判断当前集合是否为空
        System.out.println(collection.isEmpty());
    }
}
