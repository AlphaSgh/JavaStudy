package com.ssgh.demo01.Draw2;

public class DrawTest {
    public static void main(String[] args) {
        Account account = new Account("123456", 1000);
        new DrawThread("one", account, 800).start();
        new DrawThread("two", account, 800).start();
    }
}