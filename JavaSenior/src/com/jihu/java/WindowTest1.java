package com.jihu.java;
/**
 * 例子：创建三个窗口买票，总票数为100张 使用实现Runnable接口的方式
 *
 *
 */
class Window1 implements Runnable{

    public static int ticket = 100;

    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName()+":卖票，票号为："+ticket);
                ticket--;
            }
        }
    }
}
public class WindowTest1 {

    public static void main(String[] args) {
        Window1 window1 = new Window1();

        Thread w1 = new Thread(window1);
        Thread w2 = new Thread(window1);
        Thread w3 = new Thread(window1);

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();

    }
}
