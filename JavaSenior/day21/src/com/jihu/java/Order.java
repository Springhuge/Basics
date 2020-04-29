package com.jihu.java;

/**
 * 自定义泛型类
 * @param <T>
 */
public class Order<T> {

    private String orderName;
    private Integer orderId;

    //类的内部结构就可以使用类的泛型
    private T orderT;

    public Order(){

    }

    public Order(String orderName,Integer orderId,T orderT){
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    //静态方法不能使用类的泛型
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

//    public void show(){
//        try {
//
//        }catch (T t){
//
//        }
//    }
}
