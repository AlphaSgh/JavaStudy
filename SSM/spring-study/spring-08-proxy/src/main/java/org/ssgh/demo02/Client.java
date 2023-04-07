package org.ssgh.demo02;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();//真实角色

        UserServiceProxy proxy = new UserServiceProxy(); //静态代理类
        proxy.setUserService(userService); // 设置代理角色

        proxy.add();
    }
}
