package com.ssgh.demo01.ThreadGroup;

public class ThreadGroutTest {
    public static void main(String[] args) {
        //获取主线程所在线程组，这是所有默认的线程组
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("主线程组名字：" + mainGroup.getName());
        System.out.println("主线程组是否为后台线程组：" + mainGroup.isDaemon());
        new MyThead("主线程组的线程").start();
        ThreadGroup tg = new ThreadGroup("新线程组");
        tg.setDaemon(true);
        System.out.println("tg 线程组是否为后台线程组：" + tg.isDaemon());
        MyThead tt = new MyThead(tg, "tg组的线程甲");
        tt.start();
        new MyThead(tg, "tg组的线程乙").start();
        System.out.println("tt线程所属线程组：" + tt.getThreadGroup().getName());
    }
}
class MyThead extends Thread {
    //提供线程名构造器
    public MyThead(String name) {
        super(name);
    }
    //提供指定线程名，线程组的构造器
    public MyThead(ThreadGroup group, String name) {
        super(group, name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(getName() + " 线程的i变量" + i);
        }
    }
}
