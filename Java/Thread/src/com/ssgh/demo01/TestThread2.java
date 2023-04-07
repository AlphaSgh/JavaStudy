package com.ssgh.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程下载
public class TestThread2 extends Thread{
    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }
    //下载图片的线程执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://msn-img-nos.yiyouliao.com/inforec-20230104-71598ddc85d7750abac72f722187ba22.jpg?time=1672819513&signature=66E5B9F917043B8F2402D265B7AAAE9F", "1.jpg");
        TestThread2 t2 = new TestThread2("https://msn-img-nos.yiyouliao.com/inforec-20230104-d3ff0aaec4f18a9ec76e9afc3a6f6a18.jpg?time=1672819513&signature=B16A3401E47CF70498ECF36767E8B7B9", "2.jpg");
        TestThread2 t3 = new TestThread2("https://msn-img-nos.yiyouliao.com/inforec-20230104-f1d955433fed569e86cdbeace0c35d02.jpg?time=1672819513&signature=AB9E255BDD129367E1AE10D1A57EE600", "3.jpg");

        //分析，先下载t1,t2,t3,但结果不是123，而是谁先下载完谁执行
        t1.start();
        t2.start();
        t3.start();
    }
}

//下载器
class WebDownloader {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO exception, downloader problem!");
        }
    }
}
