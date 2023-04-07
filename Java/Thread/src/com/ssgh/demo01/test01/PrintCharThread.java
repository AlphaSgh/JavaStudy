package com.ssgh.demo01.test01;

public class PrintCharThread implements Runnable{
    private PrintNC printNC;
    public PrintCharThread(PrintNC printNC) {
        this.printNC = printNC;
    }
    @Override
    public void run() {
        for (int i = 0; i < 52; i++) {
            printNC.printChar(i);
        }
    }
}
