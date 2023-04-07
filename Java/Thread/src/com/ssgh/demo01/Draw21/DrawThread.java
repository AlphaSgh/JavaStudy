package com.ssgh.demo01.Draw21;

public class DrawThread implements Runnable {
    private Account account;//模拟用户账户
    private double drawAmount;//当前取钱用户希望取得钱数
    public DrawThread(Account account, double drawAmount) {
        this.account = account;
        this.drawAmount = drawAmount;
    }
    //当多个线程修改同一个共享数据时，将涉及数据安全问题
    @Override
    public void run() {
        //直接调用account对象的draw方法进行取钱操作,通过加锁的方式实现线程数据安全
        account.draw(drawAmount);//取钱操作
    }
}
