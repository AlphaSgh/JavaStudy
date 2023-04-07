package com.ssgh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestException {
    @RequestMapping("/test/exception")
    public void testException() {
        System.out.println(1/0);
    }
}
