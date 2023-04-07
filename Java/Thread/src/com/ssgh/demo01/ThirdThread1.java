package com.ssgh.demo01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThirdThread1 implements Callable {
    private int i;
    @Override
    public Object call() throws Exception {
        for ( ; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值：" + i);
        }
        return i;
    }

    public static void main(String[] args) {
        ThirdThread1 thread1 = new ThirdThread1();
        FutureTask task = new FutureTask<>(thread1);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值：" + i);
            if (i == 20) {
                new Thread(task, "one").start();
            }
        }
        try {
            System.out.println("子线程one的返回值：" + task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
