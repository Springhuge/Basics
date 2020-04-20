package com.jihu.java;

class Window2 extends  Thread{

    private static  int ticket = 100;

    private static  Object obj  = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (Window2.class){

                for (int i = 0; i <  100; i++) {

                    if(ticket > 0){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "卖票,票号为" + ticket);
                        ticket--;
                    }else {
                        break;
                    }
                }
            }
        }
        }

}


/**
 * 例子：创建三个窗口买票，总票数为100张，使用继承Thread类的方式
 *
 * 使用同步代码块解决继承Thread类
 *
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器
 *
 */
public class WindowTest2 {

    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
