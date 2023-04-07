package com.ssgh.demo01.test01;

public class PrintNumThread implements Runnable{
    private PrintNC printNC;
    public PrintNumThread(PrintNC printNC) {
        this.printNC = printNC;
    }
    @Override
    public void run() {
        for (int i = 0; i < 51; i++) {
            printNC.printNum(i);
        }
    }
}
