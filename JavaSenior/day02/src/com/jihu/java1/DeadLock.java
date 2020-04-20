package com.jihu.java1;

class A{
    public synchronized void foo(B b){
        System.out.println("当前线程名:"+Thread.currentThread().getName()+
        "进入了A实例的foo方法");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名:"+Thread.currentThread().getName()+
                "企图调用B实例的last方法");
        b.last();
    }

    public synchronized void last(){  //同步监视器 A类的对象 a
        System.out.println("进入了A类的last方法内部");
    }
}

class B {
    public synchronized void bar(A a){
        System.out.println("当前线程名:"+Thread.currentThread().getName()+
                "进入了B实例的bar方法");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名:"+Thread.currentThread().getName()+
                "企图调用A实例的last方法");
        a.last();
    }

    public synchronized void last(){ //同步监视器 B类的对象 b
        System.out.println("进入了B类的last方法内部");
    }
}

public class DeadLock implements Runnable{

    A a = new A();
    B b = new B();

    public void init(){
        Thread.currentThread().setName("主线程");
        //调用a对象的foo方法
        a.foo(b);
        System.out.println("进入了主线程之后");
    }

    public void run(){
        Thread.currentThread().setName("副线程");
        //调用a对象的foo方法
        b.bar(a);
        System.out.println("进入了副线程之后");
    }

    public static void main(String[] args) {
        DeadLock dl = new DeadLock();
        new Thread(dl).start();

        dl.init();
    }

}
