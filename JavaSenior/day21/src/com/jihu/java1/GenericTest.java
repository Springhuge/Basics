package com.jihu.java1;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import java.util.*;

/**
 * 1.泛型在继承方面的体现
 *
 * 2.通配符的使用
 *
 */
public class GenericTest {

    /**
     * 1.泛型在继承方面的体现
     */
    public void test1(){
        Object obj = null;
        String str = null;

        obj = str;

        Object[] arr1 = null;
        Object[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        //此时的list1和list2的类型不具有父子类关系
//        list1 = list2;

        //编译不通过
        Date date = new Date();
//        str = date;

        /**
         * 反证法
         *
         * 假设 list1 = list1
         *
         * list1.add(123) 导致混入非String的数据，出错
         */
    }

    public void show1(List<String> list){

    }

    public void show(List<Object> list){

    }

    @Test
    public void test2(){

        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;
        List<String> list4 = new ArrayList<>();
    }

    /**
     * 通配符的使用
     * 通配符：？
     *
     * 类A是类B的父类 G<A>和G<B>是没有关系的 二者共同的父类是G<?>
     */
    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;

        print(list1);
        print(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;

        //添加 对于List<?>就不能向其内部添加数据
//        list.add("DD");
//        list.add('?');

        list.add(null);

        //获取（读取）
        Object o = list.get(0);
        System.out.println(o);
    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
    }

    /**
     * 3.有限制条件的通配符使用
     *  ? extends A:
     *      G <? extends A> 可以做为G<A>和G<B> 的父类的 其中B是A的子类
     *  ? super A:
     *      G <? super A> 可以做为G<A>和G<B> 的父类的 其中B是A的父类
     * ? extends Person;
     * ? super Person;
     */
    @Test
    public void test4(){

        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

        //读取数据
        list1 = list4;
        Person p  = list1.get(0);
        //编译不通过
//        Person aa  = list2.get(0);

        //写入数据
        //编译不通过
//        list1.add(new Student());

        list2.add(new Person());
        list2.add(new Student());

    }


}
