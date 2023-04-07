package com.ssgh.demo01.Draw4;

public class DrawTest {
    public static void main(String[] args) {
        Account account = new Account("123456", 0);
        new DrawThread("draw01", account, 800).start();
        new DrawThread("draw02", account, 800).start();
        new DrawThread("draw03", account, 800).start();
        new DepositThread("deposit01", account, 800).start();
        new DepositThread("deposit02", account, 800).start();
        new DepositThread("deposit03", account, 800).start();
    }
}
