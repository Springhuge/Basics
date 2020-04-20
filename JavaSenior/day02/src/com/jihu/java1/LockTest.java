package com.jihu.java1;


import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock -------JDK5.0新增
 *
 *1.面试题：synchronized 与 Lock的异同
 * 同：二者都可以解决线程安全问题
 * 异：synchronized机制在执行完相应的同步代码逻辑后，自动的释放同步监视器
 *     lock需要手动的启动同步Lock()，同时结束同步也需要手动的实现(unlock())
 *
 *2.优先使用顺序
 * Lock -》 同步代码块（已经进入了方法体，分配了相应资源）-》同步方法（在方法体之外）
 *
 *
 * 面试题：如何解决线程安全问题？有几种方式
 *
 */
class Window implements Runnable{

    private  static  int ticket  = 100;

    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                //2.调用lock()
                lock.lock();
                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":售票，票号为:"+ticket);
                    ticket--;
                }else{
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //3.调用解锁方法:unlock();
                lock.unlock();
            }
        }
    }
}


public class LockTest {

    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();;


    }
}
