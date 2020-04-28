package com.jihu.java;

import org.junit.Test;

import java.util.*;

/**
 * Collections:操作Collection、Map工具类
 *
 * 面试题：Collection 和 Collections的区别？
 */
public class CollectionsTest {

    @Test
    public void test1(){
        List list = new ArrayList<Integer>(Arrays.asList(123,43,765,-97,0));
        System.out.println(list);

        //Collections.reverse(list);
        Collections.shuffle(list);
        System.out.println(list);

    }

    @Test
    public  void test2(){
        List list = new ArrayList<Integer>(Arrays.asList(123,43,765,-97,0));
        List dist = Arrays.asList(new Object[list.size()]);
        Collections.copy(dist,list);
        System.out.println(dist);


        //返回的list1即为线程安全的list
        List list1 = Collections.synchronizedList(list);
    }


}
