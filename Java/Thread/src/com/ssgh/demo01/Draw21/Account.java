package com.ssgh.demo01.Draw21;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final ReentrantLock lock = new ReentrantLock();//定义锁对象
    private String accountNo;
    private double balance;
    public Account() {}
    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;

    }
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }
    //提供一个draw()方法完成取钱操作
    public void draw(double drawAmount) {
        lock.lock();//加锁
        try {
            if (balance >= drawAmount) {
                System.out.println(Thread.currentThread().getName() + " 取钱成功，取钱 " + drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance -= drawAmount;
                System.out.println("余额为： " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " 取钱失败，余额不足");
            }
        } finally {
            //修改完成，释放锁
            lock.unlock();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o != null && o.getClass() == Account.class) {
            Account target = (Account) o;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }
}
