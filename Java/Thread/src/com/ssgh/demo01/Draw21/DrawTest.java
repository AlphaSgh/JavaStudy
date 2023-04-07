package com.ssgh.demo01.Draw21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DrawTest {
    public static void main(String[] args) {
        Account account = new Account("123456", 1000);
        DrawThread dt = new DrawThread(account, 800);

        Thread target = new Thread(dt, "one");
        Thread target1 = new Thread(dt, "one");

        ExecutorService pool = Executors.newFixedThreadPool(6);
        //像线程池中提交两个线程
        pool.submit(target);
        pool.submit(target1);
    }
}