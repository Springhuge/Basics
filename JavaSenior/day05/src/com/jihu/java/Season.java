package com.jihu.java;

//自定义枚举类
public class Season{
    //1.声明Season对象的属性:private final 修饰
    private final String seasonName;
    private final String SeasonDesc;

    //2.私有化类的构造器 并给对象属性赋值
    private Season(String seasonName, String SeasonDesc){
        this.seasonName = seasonName;
        this.SeasonDesc = SeasonDesc;
    }

    //3.提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTHMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    //4.其他诉求 获取枚举类对象的属性


    public String getSeasonDesc() {
        return SeasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    //4.其他诉求1：ToString()
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", SeasonDesc='" + SeasonDesc + '\'' +
                '}';
    }
}

