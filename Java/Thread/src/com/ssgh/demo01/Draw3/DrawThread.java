package com.ssgh.demo01.Draw3;

public class DrawThread extends Thread {

    private Account account;//模拟用户账户
    private double drawAmount;//取款数
    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.draw(drawAmount);
        }
    }
}
