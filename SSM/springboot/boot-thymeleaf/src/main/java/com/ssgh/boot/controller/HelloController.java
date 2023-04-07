package com.ssgh.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/success")
    public String success(Model model) {
        model.addAttribute("msg", "hello thymeleaf");
        model.addAttribute("link", "www.baidu.com");
        return "success";
    }
}
