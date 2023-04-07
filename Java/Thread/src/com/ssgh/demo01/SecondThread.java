package com.ssgh.demo01;

public class SecondThread implements Runnable {
    private int i;
    @Override
    public void run() {
        for ( ; i < 100; i++) {
            //当线程类实现Runnable接口时，如果想获得当前线程只能通过Thread.currentThread()方法获取
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                SecondThread st = new SecondThread();//创建Runnable类的实例
                new Thread(st, "one").start();//以Runnable类的实例作为target来创建Thread对象，并调用start()启动线程
                new Thread(st, "two").start();
            }
        }
    }
}
