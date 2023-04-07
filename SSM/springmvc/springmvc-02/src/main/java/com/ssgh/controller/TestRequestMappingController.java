package com.ssgh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {
    //访问路径为/test/hello
    //访问路径为/hello 或者 /abc
    //@RequestMapping派生注解@GetMapping@PostMapping@PutMapping@DeleteMapping
    @RequestMapping(
            value = {"/hello","/abc"},
            method = {RequestMethod.POST, RequestMethod.GET},
            //params = {"username","!password","age=20","gender!=male"}///hello?username=admin&gender=fmale&age=20必须包含username age=20 不能包含password 如果存在gender不能为male
            headers = {"referer"}//请求头中必须包含referer "header" "!header" "header=value" "header!=value"
    )
    public String hello() {
        return "success";
    }
    @RequestMapping("/**/test/ant")//1.?: 任意单个字符；2.*: 代表任意个数的任意字符；3.**:代表任意层数的任意目录 只能把**写在双斜线中前后不能有其他字符
    public String testAnt() {
        return "success";
    }
    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        System.out.println("id: " + id + ", username: " + username);
        return "success";
    }

}
