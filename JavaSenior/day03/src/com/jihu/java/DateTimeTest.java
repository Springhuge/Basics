package com.jihu.java;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 */
public class DateTimeTest {

    //1.System类中的currentTimeMills()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0秒之间以毫秒为单位的时间差
        //称为时间戳
        System.out.println(time);
    }

    /**
     * java.util.Date类
     *  |---java.sql.Date类
     *
     * 1.两个构造器的使用
     *
     * 2.两个方法的使用
     *      >toString():显示当前的年、月、日、时、分、秒
     *      >getTime():获取当前Date对象对应的毫秒数。(时间戳)
     *
     * 3.java.sql.Date:对应数据库中的日期类型变量
     *      >如何实例化
     *      >如何将util.Date对象转换为java.sqlDate对象
     */
    @Test
    public void test2(){
        //构造器一:Date(); 创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString()); //Wed Apr 22 11:02:25 CST 2020

        System.out.println(date1.getTime());

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1587525052823L);
        System.out.println(date2);

        java.sql.Date date3 = new java.sql.Date(1587525101627L);
        System.out.println(date3);

        //如何将util.Date对象转换为java.sqlDate对象
        //情况一
//        Date date4 = new java.sql.Date(22323232323233L);
//        java.sql.Date date5 =  (java.sql.Date)date4;

        //情况二:
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());


    }

}
