package com.ssgh.controller;

import com.ssgh.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class TestAjaxController {
    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, HttpServletResponse response) throws IOException {
        System.out.println("id: " + id);
        response.getWriter().write("hello, axios");
    }
//    @RequestMapping("/test/RequestBody/json")
//    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
//        System.out.println(user);
//        response.getWriter().write("hello RequestBody");
//    }
    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello RequestBody");
    }
    @RequestMapping("/test/responseBody")
    @ResponseBody
    public String testResponseBody() {
        return "success";
    }
    @RequestMapping("test/testResponseBody/json")
    @ResponseBody
    public Map<String, Object> testResponseBodyJson() {
        User user1 = new User("ssgh1", "111111", 21, "male");
        User user2 = new User("ssgh2", "111111", 21, "male");
        User user3 = new User("ssgh3", "111111", 21, "male");
        Map<String, Object> map = new HashMap<>();
        map.put("1001", user1);
        map.put("1002", user2);
        map.put("1003", user3);
        return map;
    }

//    public List<User> testResponseBodyJson() {
//        User user1 = new User("ssgh1", "111111", 21, "male");
//        User user2 = new User("ssgh2", "111111", 21, "male");
//        User user3 = new User("ssgh3", "111111", 21, "male");
//        List<User> users = Arrays.asList(user1, user2, user3);
//        return users;
//    }


//    public User testResponseBodyJson() {
//        User user = new User("ssgh", "111111", 21, "male");
//        return user;
//    }

}
