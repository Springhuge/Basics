package com.jihu.java;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 * 1.jdk5.0新增的特性
 *
 *
 * 2.在集合中使用泛型
 *  总结：
 *  ①集合接口或集合类在jdk5.0时都修改为带泛型的结构
 *  ②在实例化集合类时，可以指明具体的泛型类型
 *  ③指明完以后，在集合类或接口中凡是定义类或接口时，内部结构(比如：方法、构造器、属性)使用到类的泛型位置，都指定为实例化的泛型
 *      比如：add(E e) --》实例化之后add(Integer a);
 *  ④注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置
 *  ⑤如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
 *
 *  3.自定义泛型结构：泛型类、泛型接口、泛型方法
 *
 *
 */
public class GenericTest {

    //在集合中使用泛型之前的情况
    @Test
    public void test1(){
        //需求：存储学生的成绩
        ArrayList list = new ArrayList<>(Arrays.asList(78,76,89.88));

        //问题一：类型不安全
        list.add("Tom");
        for (Object score : list) {
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (int) score;
            System.out.println(score);
        }
    }

    //在集合中使用泛型的情况
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(78,76,89,88));

        //编译时，就会进行类型检查，保证数据的安全
        //list.add("Tom");
//        for (Integer score : list) {
//            //避免强转的操作
//            System.out.println(score);
//        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //在集合中时使用泛型到达情况，以HashMap为例
    @Test
    public void test3(){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

//        map.put(123,"ABC");
        for (Map.Entry<String, Integer> obj : map.entrySet()) {
            String key = obj.getKey();
            Integer value = obj.getValue();
        }
    }
}
