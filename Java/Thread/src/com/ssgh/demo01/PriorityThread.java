package com.ssgh.demo01;

public class PriorityThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " 的优先级是：" + getPriority() + " 循环变量是：" + i);
        }
    }
    public PriorityThread(String name) { //现场构造器，设置线程名字
        super(name);
    }

    public static void main(String[] args) {
        Thread.currentThread().setPriority(6);//设置main主线程优先级
        for (int i = 0; i < 30; i++) {
            if (i == 10) {
                PriorityThread low = new PriorityThread("low");
                low.start();
                System.out.println(low.getName() + " 创建之初的优先级：" + low.getPriority());
                low.setPriority(Thread.MIN_PRIORITY);
            }
            if (i == 20) {
                PriorityThread high = new PriorityThread("high");
                high.start();
                System.out.println(high.getName() + " 创建之初的优先级：" + high.getPriority());
                high.setPriority(Thread.MAX_PRIORITY);
            }
        }
    }
}
