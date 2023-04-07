package org.ssgh.demo01;

public class Client {
    public static void main(String[] args) {
        //房东租房子
        Host host = new Host();
        //代理，中介帮房东租房子，代理角色一般会添加附属操作
        Proxy proxy = new Proxy(host);
        //找代理进行租房
        proxy.rent();
    }
}
