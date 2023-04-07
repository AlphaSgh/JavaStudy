package com.ssgh.demo01;

public class DaemonThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        DaemonThread daemon = new DaemonThread();
        daemon.setDaemon(true);//设置后台线程
        daemon.start();//启动后台线程
        System.out.println(daemon.isDaemon());//Thread.isDaemon()判断线程是否为后台线程

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        //前台线程main结束，后台线程也随之结束
        //主线程main为唯一的前台线程
    }
}
