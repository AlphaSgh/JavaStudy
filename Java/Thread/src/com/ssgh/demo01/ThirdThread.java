package com.ssgh.demo01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThirdThread {
    public static void main(String[] args) {
        //01创建Callable对象
        ThirdThread rt = new ThirdThread();
        //先使用Lambda表达式创建Callable<Integer>对象
        //使用FutureTask来包装Callable对象
        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>) () -> {
            int i = 0;
            for ( ; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            //call()方法可以有返回值
            return i;
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                new Thread(task, "task").start();//实质还是以Callable对象来启动线程
            }
        }
        try {
            System.out.println("子线程返回值： " + task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
