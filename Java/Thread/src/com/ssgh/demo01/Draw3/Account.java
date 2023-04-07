package com.ssgh.demo01.Draw3;

public class Account {
    private String accountNo;//账号
    private double balance;//余额
    private boolean flag = false;//标识是否有存款
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

    public double getBalance() { //账户余额不可以随便修改只提供get方法
        return balance;
    }
    public synchronized void draw(double drawAmount) {
        try {
            if (!flag) { //如果flag为false，表明账户中没有存款，取钱方法为阻塞
                wait();
            } else {
                //执行取钱操作
                System.out.println(Thread.currentThread().getName() + " 取钱 " + drawAmount);
                balance -= drawAmount;
                System.out.println("账户余额为： " + balance);
                //取完钱之后将flag设置为false
                flag = false;
                //唤醒其他线程
                notifyAll();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void deposit(double depositAmount) {
        try {
            //如果flag为真，表明账户存在余额，不可再次存入,wait()等待
            if (flag) {
                wait();
            } else {
                //执行存款操作
                System.out.println(Thread.currentThread().getName() + " 存款：" + depositAmount);
                balance += depositAmount;
                System.out.println("账户余额为： " + balance);
                //将账户flag设置为true表明已存入，待取款
                flag = true;
                //幻想其他线程
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o != null && o.getClass() == com.ssgh.demo01.Draw2.Account.class) {
            com.ssgh.demo01.Draw2.Account target = (com.ssgh.demo01.Draw2.Account) o;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }
}
