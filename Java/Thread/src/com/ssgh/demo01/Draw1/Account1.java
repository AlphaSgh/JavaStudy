package com.ssgh.demo01.Draw1;

public class Account1 {
    private String accountNo;
    private double balance;
    public Account1() {}
    public Account1(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;

    }
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    //因为账户余额不允许随便修改，所以只提供Balance的get方法
    public double getBalance() {
        return balance;
    }
    //提供一个线程安全的draw方法来完成取钱操作
    public synchronized void draw(double drawAmount) {
        if (balance >= drawAmount) {
            //吐出钞票
            System.out.println(Thread.currentThread().getName() + " 取钱成功，吐出钞票 " + drawAmount);
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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o != null && o.getClass() == Account1.class) {
            Account1 target = (Account1) o;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }
}
