package com.jihu.java;

import org.junit.Test;

/**
 * 关于StringBuffer 和 StringBuilder的使用
 */
public class StringBufferBuilderTest {

    /**
     * String StringBuffer StringBuilder三者的异同？
     * <p>
     * String:不可变的字符序列：底层使用char[]存储
     * StringBuffer:可变的字符序列 线程安全 效率低 底层char[]存储
     * StringBuilder:可变的字符序列 jdk5.0新增 线程不安全 效率高 底层char[]存储
     * <p>
     * 源码分析：
     * String str = new String();//char[] value = new char[0]
     * String str1 = new String("abc");//char[] value = new char[]{'a','b','c'};
     * <p>
     * StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建了一个长度是16的数组
     * sb1.append('a');//value[0] = 'a';
     * sb1.append('b');//value[1] = 'b';
     * <p>
     * StringBuffer sb2 = new StringBuffer("abc"); //char[] value = new char["abc".length() + 16];
     * <p>
     * //问题一：System.out.println(str2.length()); //3
     * //问题二：扩容问题：如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组
     * 默认情况下，扩容为原来容量的2倍+2，同时将将由原有数组中的元素复制到新的数组中
     * <p>
     * 指定意义:开发中建议使用：StringBuffer(int capacity) 或 StringBuider(int capacity)
     */
    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer("abc");
        System.out.println(sb2.length()); //3
    }

    /**
     * StringBuffer 的常用方法
     * StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
     * StringBuffer delete(int start,int end)：删除指定位置的内容
     * StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
     * StringBuffer insert(int offset, xxx)：在指定位置插入xxx
     * StringBuffer reverse() ：把当前字符序列逆转
     * <p>
     * 总结：
     * 增:append(xxx);
     * 删:delete(int n ,char ch)
     * 改:setCharAt()/replace()
     * 查:charAt()
     * 插:insert()
     * 长度:length()
     * 遍历:for() + charAt()
     */
    @Test
    public void test2() {
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');

        System.out.println(s1);
        //s1.delete(2,4);
        // s1.insert(2,false);
        s1.reverse();
        System.out.println(s1);
        System.out.println(s1.length());
    }

    /**
     * 对比String StringBuffer StringBilder三者的效率
     *
     * 从高到低排列：StringBuilder StringBuffer String
     */
    @Test
    public void test3() {
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }

}
