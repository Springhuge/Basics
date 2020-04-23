package com.jihu.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * JDK 8 中日期事件API的测试
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate(){
        //偏移量
        Date date1 = new Date(2020 - 1900,9 - 1,8);
        System.out.println(date1);
    }

    /**
     * LocalDate LocalTime LocalDateTime的使用
     *
     * 说明：
     * 1.LocalDateTime相较于LocalDate LocalTime 使用频率更高
     */
    @Test
    public void test1(){
        //now() 获取当前日期、时间、日期+时间
        LocalDate localDate =  LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定的年 月 日 时 分 秒 没有偏移量
        LocalDateTime localDateTime1 = localDateTime.of(2020, 10, 6, 13, 23, 55);
        System.out.println(localDateTime1);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //体现不可变性
        //withXxx():设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        //
        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }

    /**
     * Instant的使用
     */
    @Test
    public void test2(){
        //now() 获取本子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        //添加事件的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取自1970年1月1日0时0分0秒 开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        Instant instant1 = Instant.ofEpochMilli(1587622871408L);
        System.out.println(instant1);
    }

    /**
     * DateTimeFormatter:格式化或解析日期和时间
     * 类似于SimpleDateFormat
     */
    @Test
    public void test3(){
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = isoLocalDateTime.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        //解析：字符串 --》 日期
        TemporalAccessor parse = isoLocalDateTime.parse("2020-04-23T14:31:01.869");
        System.out.println(parse);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String format = formatter1.format(localDateTime);
        System.out.println(format);

        String str2 = localDateTime.format(formatter1);
        System.out.println(str2);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);

        //自定义格式
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str4 = formatter3.format(localDateTime.now());
        System.out.println(str4);

        //解析
        //formatter3.parse()

    }
}
