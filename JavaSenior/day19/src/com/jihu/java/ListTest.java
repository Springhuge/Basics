package com.jihu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 1.List接口的框架
 *|---Collection接口:单列集合，用来存储一个一个的对象
 *          |---List接口:存储有序的、可重复的数据 -->动态数组  替换原有的数组
 *              |---ArrayList：作为List接口的主要实现类 线程不安全的，效率高 底层使用Object[]存储
 *              |---LinkedList 对于频繁的插入、删除操作 使用此类效率比ArrayList高 底层使用双向链表存储
 *              |---Vector：作为List接口的古老的实现类 线程安全 效率低 底层使用Object[]存储
 *
 *
 *  2.ArrayList的源码分析：
 *  2.1jdk7 的情况下
 *      ArrayList list = new ArrayList();//底层创建了长度时10的Object[]数组 elementData
 *      list.add(123);//elementData(0) = new Integer(123);
 *      ...
 *      list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容
 *      默认情况下，扩容为原来的容量的1.5倍，同时将原有的数据复制到新的数组中
 *
 *      结论：简易开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)
 *
 *      ;
 *
 *   2.2 jdk8中ArrayList的变化
 *      ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}，并没有创建长度为10的
 *
 *      list.add(123);//第一次调用add()时，底层才创建了长度为10的数组 并将数据123添加到elementData[0]
 *      ...
 *      后续添加和扩容操作与jdk 7 无异
 *   2.3 小结：jdk7中的ArrayList的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象
 *             的创建类似于单例的懒汉式，延迟了数组的创建，节省内存。
 *
 *   3.LinkedList的源码分析：
 *      LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
 *      list.add(123);//将123封装到了Node中，创建了Node对象
 *
 *      其中，Node定义为：体现了LinkedList的双向链表的说法
 *      private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 *    4.Vector的源码分析：jdk7 和 jdk8 中通过Vector()构造器创建对象时，底层创建了长度为10的数组
 *      在扩容方面，默认扩容为原来的数组长度的2倍
 *    5.List接口中的常用方法
 *
 *   面试题：ArrayList LinkedList Vector 三者的异同？
 *   同：三个类都实现了List接口，存储数据的特点相同的：存储有序的、可重复的数据
 *   不同：如上
 */
public class ListTest {

    @Test
    public void test1(){
        ArrayList list = new ArrayList(Arrays.asList(123,456,"AA",new Person("Tom",12),456));

        System.out.println(list);

        list.add(1,"BB");
        System.out.println(list);

        List list1 = Arrays.asList(1,2,3);
        list.addAll(list1);
        //list.add(list1);
        System.out.println(list.size());//9
        System.out.println(list);

        System.out.println(list.get(0));
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList(Arrays.asList(123,456,"AA",new Person("Tom",12),456));

        int index = list.indexOf(4567);
        System.out.println(index);

        System.out.println(list.lastIndexOf(456));

        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        list.set(1,"CC");
        System.out.println(list);

        List list1 = list.subList(2, 4);
        System.out.println(list1);
        System.out.println(list);
    }

    /**
     * 总结：常用方法
     * 增:add(Object obj)
     * 删:remove(int index)/remove(Object obj)
     * 改:set(int index,Object ele)
     * 查:get(int index)
     * 插:add(int index,Object ele)
     * 长度:size()
     * 遍历:①Iterator迭代器方式
     *      ②增强for循环
     *      ③普通的循环
     */
    @Test
    public void  test3(){
        ArrayList list = new ArrayList(Arrays.asList(123,456,"AA"));

        //方式一;Iterator迭代器方式
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("********************************");

        //方式二:普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("********************************");

        //方式三:增强for循环
        for (Object obj: list) {
            System.out.println(obj);
        }

        System.out.println("********************************");

        //方式四:Steram
        list.forEach(obj -> System.out.println(obj));

    }
}
