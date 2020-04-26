package com.jihu.java;

import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的方法的测试
 *
 * 结论：
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类重写equals()
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
//        Person p = new Person("Jerry", 20);
//        collection.add(p);
        collection.add(new Person("Jerry",20));

        //contains(Object obj):判断当前集合中是否包含obj
        //我们在判断时会调用obj对象所在类的equals()方法
        boolean contains = collection.contains(123);
        System.out.println(contains);

        System.out.println(collection.contains(new String("Tom")));
        //System.out.println(collection.contains(p));
        System.out.println(collection.contains(new Person("Jerry",20)));


        //2.containsAll(Collection coll1) 判断形参从coll1中 的所有元素是否在当前集合中
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(collection.containsAll(coll1));
    }

    @Test
    public void test2(){
        //3.remove(Object obj) 从当前集合中移除obj元素
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new Person("Jerry",20));

        collection.remove(123);
        System.out.println(collection);

        collection.remove(new Person("Jerry",20));
        System.out.println(collection);

        //4.removeAll(Collection coll1);差集 从当前集合中移除coll1中所有的元素
        Collection collection1 = Arrays.asList(123,456);
        collection.removeAll(collection1);
        System.out.println(collection);
    }

    @Test
    public void test3(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new Person("Jerry",20));

        //5.retainAll(Collection colletion) 交集：获取当前集合和collection集合交集，并修改当前集合为交集
//        Collection collection1 = Arrays.asList(123,456,789);
//        collection.retainAll(collection1);
//        System.out.println(collection);

        //6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同
        Collection collection2 = new ArrayList();
        collection2.add(123);
        collection2.add(456);
        collection2.add(new String("Tom"));
        collection2.add(false);
        collection2.add(new Person("Jerry",20));

        System.out.println(collection.equals(collection2));
    }

    @Test
    public void test4(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new Person("Jerry",20));

        //7.hashCode();返回当前对象的哈希值
        System.out.println(collection.hashCode());

        //8.集合 ---》数组 toArray()
        Object[] arr = collection.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //拓展：数组 ---》 集合  调用Arrays类的静态方法asList();
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr1.size());

        //iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试

    }
}
