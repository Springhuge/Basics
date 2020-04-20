package com.jihu.java2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程通信的例子：使用两个线程打印1-100。线程1，线程2 交替打印
 *
 *
 * 涉及到的三个方法：
 * wait() :一旦执行此方法，当前线程进入阻塞状态，并释放同步监视器
 * notify() : 一旦执行此方法，就会唤醒被wait的一个线程，如果多个线程就被wait，就唤醒优先级最高的
 * notifyAll() :一旦执行此方法，就会唤醒所有被wait的线程
 *
 * 说明：
 *  1.wait() notify() notifyAll() 三个方法必须使用在同步代码块或同步方法中
 *  2.wait() notify() notifyAll() 三个方法的调用必须是同步代码块或同步方法中的同步监视器
 *      否则，会出现IllegalMonitorStateException异常
 *  3.wait() notify() notifyAll() 三个方法是定义在java.lang.Object类中
 */
class Number implements Runnable{

    private ReentrantLock lock = new ReentrantLock();

    private  int number = 1;

    private Object object = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (object) {
                object.notifyAll();
                if(number <= 100){
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;
                    try {
                        //使得调用如下wait（）方法的线程进入阻塞状态
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }

}
public class CommunicationTest {

    public static void main(String[] args) {

        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
