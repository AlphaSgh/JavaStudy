package com.ssgh.boot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController ==> @Controller + @ResponseBody
@RestController
@EnableAutoConfiguration
public class HelloController {
    @RequestMapping("/hello")
    String handle01() {
        return "hello springboot3";
    }
}
