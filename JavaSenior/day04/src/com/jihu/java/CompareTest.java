package com.jihu.java;

import com.sun.media.sound.SoftTuning;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、说明：java中的对象，正常抢矿下，只能进行 == 或 ！= 不能使用 > 或  < 的
 *          但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小
 *          如何实现？使用两个接口的中的任何一个：Comparable 或 comparator
 *
 * 二、Comparable接口与Comparator的使用对比
 *     Comparable接口的方式一旦一定，保证Comparable接口实现类在任何位置都可以比较大小
 *     Comparator接口属于临时性的比较
 *
 *
 */
public class CompareTest {

    /**
     * 二、Comparable接口的使用
     *
     * 1.像String、包装类等实现列Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方式
     * 2.像String、包装类重写compareTo()方法之后，进行了从小到大的排序
     * 3.重写compareTo()的规则
     * 如果当前对象this大于形参对象obj，则返回正整数，
     * 如果当前对象this小于形参对象obj，则返回负数
     * 如果当前对象this等于形参对象obj，则返回零
     * 4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法
     * 在compareTo(obj)方法中指明如何排序
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","CC","MM","GG","JJ","DD"};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse",34.0);
        arr[1] = new Goods("dellMouse",43.0);
        arr[2] = new Goods("xiaomiMouse",12.0);
        arr[3] = new Goods("huaweiMouse",65.0);
        arr[4] = new Goods("microsoftMouse",43.0);
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * Comparator接口的使用：定制排序
     * 1.背景：
     * 当元素的类型没有实现java.lang.Comparable接口而不方便修改代码，
     * 或者实现了java.lang.Comparable接口的排序不适合当前的操作
     * 那么可以考虑使用Comparator的对象来排序
     * 2.重写compare(Object o1 Object o2)方法比较 o1和o2的大小
     */
    @Test
    public void  tets3(){
        String[] arr = new String[]{"AA","CC","MM","GG","JJ","DD"};
        //按照字符串从大到小排序
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return  -s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse",34.0);
        arr[1] = new Goods("dellMouse",43.0);
        arr[2] = new Goods("xiaomiMouse",12.0);
        arr[3] = new Goods("huaweiMouse",65.0);
        arr[4] = new Goods("microsoftMouse",43.0);
        Arrays.sort(arr, (o1,o2)->{
            if(o1 instanceof Object && o2 instanceof Object){
                Goods g1 = (Goods) o1;
                Goods g2 = (Goods) o2;
                if(g1.getName().equals(g2.getName())){
                    return -Double.compare(g1.getPrice(),g2.getPrice());
                }else {
                    return g1.getName().compareTo(g2.getName());
                }
            }
            return 0;
        });

        System.out.println(Arrays.toString(arr));
    }
}
