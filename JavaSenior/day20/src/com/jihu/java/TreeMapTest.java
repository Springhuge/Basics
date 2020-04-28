package com.jihu.java;

import org.junit.Test;

import java.util.TreeMap;

public class TreeMapTest {

    //向TreeMap中添加key-value 要求key必须是由同一个类创建的对象
    //因为要按照key进行排序:自然排序 定制排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap();
        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",32);
        User u3 = new User("Jack",20);
        User u4 = new User("Rose",18);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        System.out.println(map);
    }

    //定制排序
    @Test
    public void test2(){
        TreeMap map = new TreeMap((Object o1, Object o2) ->{
            if(o1 instanceof User && o2 instanceof User){
                User u1 = (User) o1;
                User u2 = (User) o2;
                return Integer.compare(u1.getAge(),u2.getAge());
            }else{
                throw new RuntimeException("输入数据类型不匹配");
            }
        });
        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",32);
        User u3 = new User("Jack",20);
        User u4 = new User("Rose",18);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        System.out.println(map);
    }

}
