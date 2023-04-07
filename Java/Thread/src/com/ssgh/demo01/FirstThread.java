package com.ssgh.demo01;

public class FirstThread extends Thread {
    private int i;
    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            //当线程类继承Thread类时，直接使用this即可获取当前线程
            //Thread对象的getName（）返回当前线程的名字
            //可以直接调用getName()方法获取当前线程的名字
            System.out.println(getName() + " " + j);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //Thread.currentThread()返回当前正在执行的线程对象
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                new FirstThread().start();
                new FirstThread().start();
            }
        }
    }
}
