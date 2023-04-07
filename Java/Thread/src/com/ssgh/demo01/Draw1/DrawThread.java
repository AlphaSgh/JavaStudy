package com.ssgh.demo01.Draw1;

public class DrawThread extends Thread {
    private Account1 account;//模拟用户账户
    private double drawAmount;//当前取钱用户希望取得钱数
    public DrawThread(String name, Account1 account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }
    //当多个线程修改同一个共享数据时，将涉及数据安全问题
    @Override
    public void run() {
        //直接调用account对象的draw方法进行取钱操作
        //同步方法的同步监视器是this，this代表调用draw()方法的对象
        //也就是说线程进入draw()方法之前，必须对account对象加锁
        account.draw(drawAmount);//取钱操作
    }
}
