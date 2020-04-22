package com.jihu.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 */
public class StringTest1 {

    /**
     * String与基本数据类型、包装类之间的转换
     *
     * String --》基本数据类型 包装类：调用包装类的静态方法 Integer.pasrseXxx(str)
     *
     * 基本数据类型、包装类 --》String
     */
    @Test
    public void test1(){
        String str1 = "123";
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);
        String str3 = num+"";

        System.out.println(str1 == str3);
    }

    /**
     * String 与 char[]之间的转换
     *
     * String --> char[]:调用String的toCharArray()
     * char[] --> String:调用String的构造器
     */
    @Test
    public void test2(){
        String str1 = "abc123";
        char[] chars = str1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        char[] arr = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }

    /**
     * String 与 byte[] 之间的转换
     *
     * 编码:String -- > byte[]:调用String 的 getBytes()
     * 解码:byte[] -- > String:String 的构造器
     *
     * 编码：字符串 --> 字节 （看得懂 --> 看不懂的二进制编码）
     * 解码：编码的逆过程，字节 --> 字符串（看不懂的二进制数据 --> 看得懂）
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集 进行转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk"); //使用
        System.out.println(Arrays.toString(gbks));

        System.out.println("************************************");
        String utf8 = new String(bytes);
        System.out.println(utf8);

        String 废材 = new String(gbks);
        System.out.println(废材);

        String gbk = new String(gbks, "gbk");
        System.out.println(gbk);

    }
}
