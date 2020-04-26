package com.jihu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素遍历操作，使用迭代器Iterator接口
 * 1.内部方法：hashNext() 和 next();
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，
 *  默认游标都在集合的第一个元素
 * 3.内部定义了remove()，可以在遍历的时候，删除集合中的元素，
 *  此方法不同于集合直接调用remove()方法
 */
public class IteratorTest {

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new Person("Jerry",20));

        Iterator iterator = collection.iterator();
        //方式一：

        //方式二：不推荐
        for(int i =0;i < collection.size();i++){
            System.out.println(iterator.next());
        }

        //方式三：推荐
        while (iterator.hasNext()){
            //next():①指针下移 ②将下移以后的集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new Person("Jerry",20));

        Iterator iterator = collection.iterator();

        //错误方式一：
//        while (iterator.next() != null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：
        //集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素
        while (collection.iterator().hasNext()){
            System.out.println(collection.iterator().next());
        }
    }

    //测试Iterator中的remove()
    //如果还未调用next()或在上一次调用next方法之后已经调用了remove方法
    //再调用remove都会报IllegalStateException
    @Test
    public void test3(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new Person("Jerry",20));

        System.out.println(collection);

        //删除Iterator中的remove()
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }
        System.out.println(collection);

    }

}
