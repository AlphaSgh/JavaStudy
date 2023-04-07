package com.ssgh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 查询所有用户信息--》/user--->get
 * 根据ID查询用户信息--》/user/1--->get
 * 添加用户信息--》/user--->post
 * 修改用户信息--》/user--->put
 * 删除用户信息--》/user/1--->delete
 */
@Controller
public class TestRestController {
//    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getAllUser() {
        System.out.println("查询所有用户信息/user--->get");
        return "success";
    }
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Integer id) {
        System.out.println("user id " + id);
        return "success";
    }
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping("/user")
    public String addUser() {
        System.out.println("添加用户");
        return "success";
    }
//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping("/user")
    public String updateUser() {
        System.out.println("修改用户");
        return "success";
    }
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        System.out.println("delete id " + id + " user");
        return "success";
    }
}
