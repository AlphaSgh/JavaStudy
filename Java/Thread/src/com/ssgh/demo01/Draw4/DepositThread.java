package com.ssgh.demo01.Draw4;

public class DepositThread extends Thread {
    private Account account;//账户
    private double depositAmount;//存款数
    public DepositThread(String name, Account account, double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }
    @Override
    public void run() {
        //100次存款操作
        for (int i = 0; i < 100; i++) {
            account.deposit(depositAmount);
        }
    }
}
