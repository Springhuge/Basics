package com.jihu.java;

import java.util.concurrent.locks.ReentrantLock;

class Window1 implements Runnable{

    private static int ticket = 100;

    Object obj = new Object();

    ReentrantLock lock = new ReentrantLock();

    @Override
    public  void run() {
        while (true) {
            synchronized(this){
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票,票号为" + ticket);
                    ticket--;
                } else {
                    Thread.currentThread().stop();
                    break;
                }
            }
        }
    }
}

/**
 * 例子：创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
 *
 * 1.问题：卖票过程中，出现了重票，错票 --》线程安全问题
 * 2.问题出现的原因：当某个线程操作车票过程中，尚未操作完成时，其他线程参与进来，也操作车票
 * 3.如何解决：当一个线程在ticket的时候，其他线程不能参与进来，知道线程a操作完ticket
 *          其他线程才可以开始操作ticket，这种情况，即使线程a出现了阻塞，也不能改变
 * 4.在java中，我们通过同步机制，来解决线程的安全问题
 *
 *  方式一：同步代码块
 *  synchronized(同步监视器){
 *      //需要被同步的代码
 *
 *  }
 *说明：1.操作共享数据的代码，即为需要被同步的代码 --》不能包含代码多了，不能包含代码少了
 *      2.共享数据：多个线程共同操作的变量 比入：ticket就是共享数据
 *      3.同步监视器，俗称：锁 任何一个类的对象 都可以充当锁
 *          要求：多个线程必须要共用同一把锁
 *
 *      补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器
 *
 *  方式二：同步方法
 *      如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的
 *
 *
 *
 *  5.同步的方式，解决了线程的安全问题  ---好处
 *     操作同步代码时，只能由一个线程参与，其他线程等待，相当于是一个单线程的过程，效率低 ---局限性
 *
 *
 */
public class WindowTest1 {

    public static void main(String[] args) {
        Window1 w1 = new Window1();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();

    }


}
