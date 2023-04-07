package com.ssgh.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread21 implements Runnable {
    private String url;
    private String name;
    public TestThread21(String url, String name) {
        this.url = url;
        this.name = name;
    }
    @Override
    public void run() {
        WebDownloader2 webDownloader = new WebDownloader2();
        webDownloader.downLoader(url, name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        TestThread21 t1 = new TestThread21("https://msn-img-nos.yiyouliao.com/inforec-20230104-71598ddc85d7750abac72f722187ba22.jpg?time=1672819513&signature=66E5B9F917043B8F2402D265B7AAAE9F", "1.jpg");
        TestThread21 t2 = new TestThread21("https://msn-img-nos.yiyouliao.com/inforec-20230104-d3ff0aaec4f18a9ec76e9afc3a6f6a18.jpg?time=1672819513&signature=B16A3401E47CF70498ECF36767E8B7B9", "2.jpg");
        TestThread21 t3 = new TestThread21("https://msn-img-nos.yiyouliao.com/inforec-20230104-f1d955433fed569e86cdbeace0c35d02.jpg?time=1672819513&signature=AB9E255BDD129367E1AE10D1A57EE600", "3.jpg");

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}
class WebDownloader2 {
    public void downLoader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO exception, downloader problem!");
        }
    }
}