1.定义一个Employee类。

该类包含：private 成员变量 name，age，birthday，其中birthday为MyDate类的对象。

并为每一个属性定义getter，setter方法

并重写toString方法输出name，age，birthday



MyDate类包含

private成员变量 year，month，day；并为每一个属性定义getter，setter方法



创建该类的5个对象，并把这些对象放入TreeSet集合中（下一章：TreeSet需使用泛型来定义）

分别按以下两种方式对集合中的元素进行排序，并遍历输出

1.使Employee实现COmparable接口，并按name排序

2.创建TreeSet时传入Comparator对象，按生日日期的先后排序

