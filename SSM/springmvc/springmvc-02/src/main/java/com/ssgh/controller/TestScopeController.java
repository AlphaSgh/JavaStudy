package com.ssgh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class TestScopeController {
    @RequestMapping("/test/servlet")
    public String testServletApi(HttpServletRequest request) {
        request.setAttribute("testServletScope", "hello ServletAPI");
        return "success";
    }

    @RequestMapping("/test/mav")
    public ModelAndView testMAV() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("testMAVScope", "hello, ModelAndView");
        mav.setViewName("success");
        return mav;
    }
    @RequestMapping("/test/model")
    public String testModel(Model model) {
        model.addAttribute("testModelScope", "hello model");
        return "success";
    }
    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map) {
        map.put("testMapScope", "hello, map");
        return "success";
    }
    @RequestMapping("/test/model/map")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testModelMapScope", "hello modelmap");
        return "success";
    }
    @RequestMapping("/test/session")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "hello Session");
        return "success";
    }
    @RequestMapping("/test/application")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello application");
        return "success";
    }
}
