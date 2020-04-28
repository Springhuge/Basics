package com.jihu.exer1;

import org.junit.Test;

import java.util.*;

/**
 *
 * 一、Map的实现类的结构
 *  |---Map:双列数据，存储key-value对的数据 ---类似于高中的函数: y = f(x)
 *      |---HashMap:作为Map的主要实现类 线程不安全的 效率高
 *          |---LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历
 *                原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素
 *                对于频繁的遍历操作，此类执行效率高于HashMap
 *      |---TreeMap：保证按照添加的key-value对进行排序，实现排序遍历 此时考虑key的自然排序或定制排序
 *              底层使用红黑树
 *      |---HashTable:作为古老的实现类 线程安全的 效率低
 *          |---Properties：常用来处理配置文件，key和value都是String
 *
 *     HashMap的底层：数组+链表 （jdk7及之前）
 *                    数组+链表+红黑树（jdk 8 ）
 *
 *     面试题：
 *      HashMap底层实现原理？
 *      HashMap 和 HashTable的异同？
 *      CurrentHashMap 与 HashTable的异同？（暂时不讲）
 *
 *  二、Map结构的理解：
 *      Map中的key：无序的、不可重复的，使用Set存储所有的key ---》key所在的类要重写equals()和hashCode()（以HashMap为例）
 *      Map中的value：无序的、可重复的，使用Collection存储所有的value  ---》value所在的类要重写equals()
 *      一个键值对：key-value构成了一个Entry对象
 *      Map中的entry：无序的、不可重复的，使用Set存储所有的entry
 *
 *  三、HashMap的底层实现原理？以jdk7为例说明
 *      HashMap map = new HashMap();
 *      在实例化后，底层创建了长度为16的一维数组Entry[] table
 *      ...可能已经执行过多次put...
 *      map.put(key1,value1);
 *      首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算之后，得到Entry数组中的存放位置
 *      如果此位置上的数据为空，此时key1-value1添加成功 ----------情况一
 *      如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表的形式存在）），比较key1和已经存在的一个或多个数据
 *      的哈希值：
 *          如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功 ----情况二
 *          如果key1的哈希值和已经存在的某一个数据（key2-value2）哈希值相同，继续比较equals()；调用key1所在类的equals()方法 比较
 *              如果equals()返回false 此时key1-value1添加成功 ---情况三
 *              如果equals()返回true：使用value1替换value2值
 *
 *      补充：关于情况二和情况三 此时 key1-value1和原来的数据以链表的方式存储
 *
 *      在不断的添加过程中，会涉及到扩容问题 当超出临界值时(且要存放的位置非空)时 默认扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来
 *
 *      jdk8 相较于jdk7在底层实现方面的不同
 *      1.new HashMap():底层没有创建一个长度为16的数组
 *      2.jdk 底层的数组是：Node[]，而非Entry[]
 *      3.首次调用put()方法时，底层创建长度为16的数组
 *      4.jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树
 *          当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，
 *          此时索引位置上的所有数据改为使用红黑树存储
 *
 *
 *    四、LinkedHashMap的底层实现原理（了解）
 *        源码中:
 *        static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *        }
 *
 *    五、Map中定义的方法:
 *
 *     总结:常用方法
 *     添加put
 *     删除remove
 *     修改put
 *     查询
 *     插入
 *
 */
public class MapTest {

    @Test
    public void test1(){
        Map map = new HashMap();
        map = new Hashtable();
        map.put(null,123);
    }

    @Test
    public void test2(){
        Map map = new HashMap();
        map = new LinkedHashMap();

        map.put(123,"AA");
        map.put(345,"BB");
        map.put(12,"CC");

        System.out.println(map);
    }

    @Test
    public void test3(){
        Map map = new HashMap();

        map.put("AA",123);
        map.put("45",123);
        map.put("BB",56);
        //修改
        map.put("AA",87);

        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);

        map.putAll(map1);
        System.out.println(map);

        Object cc = map.remove("CC");
        System.out.println(cc);
        System.out.println(map);

        //celar()
        map.clear(); //与map=null不同
        System.out.println(map);
        System.out.println(map.size());
    }

    @Test
    public void test4(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        System.out.println(map.get(45));

        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);

        isExist= map.containsValue(123);
        System.out.println(isExist);

        map.clear();

        System.out.println(map.isEmpty());
    }

    @Test
    public void test5(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);

        //遍历所有的key集：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("*****************");
        //遍历所有的value集：values()
        Collection values = map.values();
        values.forEach(System.out::println);

        //遍历所有key-value

        //方式一：Map.Entry
        Iterator iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()){
            Object obj  = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
        }

        System.out.println("*****************");

        //方式二
        Iterator iterator2 = map.keySet().iterator();
        while (iterator2.hasNext()){
            Object key  = iterator2.next();
            Object value = map.get(key);
            System.out.println("key:"+key+" value:"+value);
        }

        System.out.println("*****************");

        for (Object key : map.keySet()) {
            System.out.println("key:"+key+" value:"+map.get(key));
        }

    }
}
