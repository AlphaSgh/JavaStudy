package com.ssgh.demo01;

//多个线程同时操作同一个对象，买火车票
//发现问题：多个线程操作同一个资源情况下，会存在线程不安全
public class TestThread4 implements Runnable {
    private int ticketNums = 10;
    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " --> 拿到了第 " + ticketNums-- + " 票。");
        }
    }

    public static void main(String[] args) {
        TestThread4 testThread4 = new TestThread4();
        new Thread(testThread4, "小明").start();
        new Thread(testThread4, "小红").start();
        new Thread(testThread4, "黄牛").start();
    }
}
