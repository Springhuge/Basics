package com.jihu.java1;

import com.jihu.java.Person;
import org.junit.Test;

import java.util.*;

/**
 * 1.Set接口的框架：
 *
 *      |---Collection接口:单列集合，用来存储一个一个的对象
 *          |---Set接口:存储无序的、不可重复的数据 -->高中讲的“集合”
 *              |---HashSet 作为Set接口的主要实现类；线程不安全，可以存储null值
 *                  |---LinkedHashSet 作为HashSet的子类，遍历其内部数据 可以按照添加的顺序遍历
 *              |---TreeSet 可以按照添加的元素指定属性，进行排序
 *
 * 1.Set接口中没有额外定义新的方法，使用的都是Collection中声明的方法
 *
 * 2.要求：向Set中添加的数据，其所在的类一定要重写hashCode()方法，和equals
 *   要求：重写的hashCode() 和 equals()尽可能保持一致性
 *         重写两个方法的小技巧，对象中用作equals()方法比较Field 都应该用来计算HashCode
 *
 */
public class SetTest {
    /**
     * 一、Set: 存储无序的、不可重复的数据
     * 以HashSet为例说明：
     * 1.无序性 不等于随机性。存储的数据在底层数组中并非按照数组的索引顺序添加 而是根据数据的哈希值添加的
     *
     * 2.不可重复性 保证添加的元素 按照equals()判断时，不能返回true 即 相同的元素只能添加一个
     *
     * 二、添加元素的过程，以HashSet为例
     *  我们向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值
     *  此哈希值通过某种算法计算出在HashSet底层数组中的存放位置（即为 索引位置） 判断
     *  数组此位置上是否已经有元素；
     *  如果此位置上没有其他元素，则元素a添加成功  情况一
     *  如果此位置上有其他元素b（或以链表形式存在的多个元素），则比较元素a与元素b的hash值
     *      如果hash值不相同，则元素a添加成功 情况二
     *      如果hash值相同，进而需要调用元素a所在类的equlas()方法
     *          equals()返回true 元素a添加失败
     *          equals()返回false 元素a添加成功 情况三
     *
     *  对于添加成功的情况二 和 情况三 而言:元素a 与 已经存在指定索引位置上的数据以链表的方式存储
     *  jdk7: 元素 a 方法到数组中 指向原来的元素
     *  jdk8: 原来的元素在数组中 指向元素a
     *
     *  HashSet地城：数组+链表的结构
     *
     *  总结：七上八下
     */
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(Arrays.asList(456,123,123,"AA","CC",new User("Tom",12),new User("Tom",12),129));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    //LinkedHashSet的使用
    //LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据维护了两个引用，记录此数据前一个数据和后一个数据
    //优点：对于频繁的遍历操作，LinkedHashSet效率高与HashSet
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(Arrays.asList(456,123,123,"AA","CC",new User("Tom",12),new User("Tom",12),129));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
