package com.jihu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8 之前的日期事件的api
 *
 * 1.System类中currenTimeMills();
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 */
public class DateTimeTest {

    /**
     * SimpleDateFormat的使用:SimpleDateFormat对日期Date类的格式化和解析
     *
     *
     * 1.两个操作
     * 1.1 格式化：日期-----》字符串
     * 1.2 解析：格式化逆过程，字符串-----》日期
     *
     * 2.SimpleDateFormat的实例化
     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化 使用默认的构造器
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        //格式化：日期 ---》字符串
        Date date = new Date();
        System.out.println(date);
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        //解析：格式化的逆过程 字符串---》日期
        String str = "19-08-09 上午11:44";
        Date date1 = simpleDateFormat.parse(str);
        System.out.println(date1);

        //*************按照指定方式格式化和解析：调用带参数构造器*************
        //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);
        //解析：要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）
        //否则 抛异常
        Date date2 = sdf1.parse("2020-02-18 11:48:27");
        System.out.println(date2);
    }

    /**
     * 练习一：字符串2020-09-08 转换为Java.sql.Date
     */
    @Test
    public void testExer() throws ParseException {
        String dateStr = "2020-09-08";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(dateStr);
        java.sql.Date birthDate = new java.sql.Date(parse.getTime());
        System.out.println(birthDate);
    }

    /**
     * 练习二：“三天打鱼两天晒网” 1999-01-01 打鱼 晒网
     *
     * 举例 2020-09-08 ？
     *
     * 总天数 % 5 == 1，2，3 打🐟
     * 总天数 % 5 == 4，0 晒网
     *
     * 总天数的计算?
     *
     * 方式一：(date2.getTime - date1.getTime) / (1000 * 60 * 60 * 24) + 1
     * 方式二：1990-01-01 --》 2019-12-31 --》 2020-09-08
     *
     */
    @Test
    public void testExer2() throws ParseException {
        String date1Str = "1999-01-01";
        String date2Str = "2020-09-12";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = simpleDateFormat.parse(date1Str);
        Date date2 = simpleDateFormat.parse(date2Str);

        Long day = (date2.getTime()-date1.getTime())/(1000 * 60 * 60 * 24);
        switch ((int) (day % 5)){
            case 0:
            case 1:
            case 2:
                System.out.println("打🐟");
                break;
            case 3:
            case 4:
                System.out.println("晒网");
                break;
        }
    }

    /**
     * Calendar 日历类的使用
     */
    @Test
    public void testCalendar(){
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,25);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //getTime() 日历类 ---》Date
        Date time = calendar.getTime();
        System.out.println(time);

        //setTime() Date ---》 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }
}
