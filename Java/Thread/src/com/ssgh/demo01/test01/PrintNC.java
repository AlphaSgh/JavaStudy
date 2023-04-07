package com.ssgh.demo01.test01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNC {
    //显式定义lock对象
    private final Lock lock = new ReentrantLock();
    //获得指定对象的Condition
    private final Condition cond = lock.newCondition();
    private char aChar = 'A';
    private int num = 1;
    private boolean flag = false;// false打印字母，true打印数字
    public void printChar(int i) {
        //加锁
        lock.lock();
        try {
            //如果flag为假，不可打印字母，
            if (!flag) {
                cond.await();
            } else {
                System.out.print((char) (aChar + i / 2));
                flag = false;
                cond.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printNum(int i) {
        lock.lock();
        try {
            //如果flag为真，表明账户存在余额，不可再次存入,wait()等待
            if (flag) {
                cond.await();
            } else {
                System.out.print(num + i);
                System.out.print(num + i + 1);
                flag = true;
                cond.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
