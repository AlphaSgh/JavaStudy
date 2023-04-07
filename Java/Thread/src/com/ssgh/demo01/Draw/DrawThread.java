package com.ssgh.demo01.Draw;

public class DrawThread extends Thread {
    private Account account;//模拟用户账户
    private double drawAmount;//当前取钱用户希望取得钱数
    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }
    //当多个线程修改同一个共享数据时，将涉及数据安全问题
    @Override
    public void run() {
        //使用account作为同步监视器，任何线程进入下面同步代码块之前必须先获得对account账户的锁定，其他线程无法获得锁
        //也就无法修改它，这种做法符合：”加锁--修改--释放锁“的逻辑
        synchronized (account) {
            //账户余额大于取钱数目，操作成功
            if (account.getBalance() >= drawAmount) {
                System.out.println(getName() + " 取钱成功，吐出钞票：" + drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.setBalance(account.getBalance() - drawAmount);
                System.out.println("账户余额为：" + account.getBalance());
            } else {
                System.out.println(getName() + " 账户余额不足，取钱失败。");
            }
        }
    }
}
