package com.ssgh.controller;

import com.ssgh.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestParamController {
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + "password: " + password);
        return "success";
    }
    @RequestMapping("/param")
    public String getParam(@RequestParam(value = "username", required = false, defaultValue = "hello") String username, String password,
                           @RequestHeader("referer") String referer,
                           @CookieValue("JSESSIONID") String jsessionid
    ) {
        System.out.println("username: " + username + " password: " + password + " jsessionid " + jsessionid);
        System.out.println(referer);
        return "success";
    }
    @RequestMapping("/parampojo")
    public String getParam(User user) {
        System.out.println(user);
        return "success";
    }
}
