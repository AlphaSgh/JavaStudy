package com.ssgh.demo01.Draw1;

public class DrawTest {
    public static void main(String[] args) {
        Account1 account1 = new Account1("123456", 1000);
        new DrawThread("one", account1, 800).start();
        new DrawThread("two", account1, 800).start();
    }
}