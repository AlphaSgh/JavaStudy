package org.ssgh.demo04;

import org.ssgh.demo02.UserService;
import org.ssgh.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();
        //代理角色，不存在，通过ProxyInvocationHandler生成
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(userService);//设置要代理的角色
        UserService proxy = (UserService) pih.getProxy();//动态生成代理类

        proxy.add();
    }
}
