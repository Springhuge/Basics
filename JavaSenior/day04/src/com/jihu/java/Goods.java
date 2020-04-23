package com.jihu.java;

public class Goods implements Comparable{

    private String name;
    private Double price;

    public Goods() {
    }

    public Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明商品比较大小的方式 按照价格从低到高排序，再按照产品名称从低到高排序
    @Override
    public int compareTo(Object o) {
//        System.out.println("***************");
        if(o instanceof Goods){
            Goods goods = (Goods) o;
            //方式一
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
//                return 0;
                return Double.compare(this.price,goods.price);
            }
            //方式二：
//            return Double.compare(this.price,goods.price);
        }
        throw  new RuntimeException("传入的数据类型不一致！");
    }
}
