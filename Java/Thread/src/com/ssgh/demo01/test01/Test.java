package com.ssgh.demo01.test01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        PrintNC printNC = new PrintNC();
        PrintNumThread pNT = new PrintNumThread(printNC);
        PrintCharThread pCT = new PrintCharThread(printNC);
        Thread target1 = new Thread(pNT);
        Thread target2 = new Thread(pCT);
        ExecutorService pool = Executors.newFixedThreadPool(6);
        //像线程池中提交两个线程
        pool.submit(target1);
        pool.submit(target2);
    }
}
