package com.jihu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口。 ----JDK5.0新增
 *
 * 如何理解实现Callable接口的方式创建多线程实现比实现Runnable接口创建多线程方式强大
 * 1.call()可以有返回值的
 * 2.call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3.Callable是支持泛型的
 */
class NumThread implements Callable<Integer> {

    //2.实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}


public class ThreadNew {

    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);
        new Thread(futureTask).start();


        try {
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
            Integer value = futureTask.get();
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
