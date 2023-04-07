package com.ssgh.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ArithmeticException.class) //@ControllerAdvice将当前类标识为异常处理的组件
    public ModelAndView handleException(Exception ex, Model model) { //ex表示当前请求处理中出现的异常对象
        ModelAndView mav = new ModelAndView();
        mav.addObject("ex", ex);
        mav.setViewName("error");
        return mav;
    }
}
