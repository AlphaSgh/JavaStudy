package org.ssgh.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//使用注解方式实现AOP
@Aspect //标注这个类是一个切面类
public class AnnotationPointCut {
    @Before("execution(* org.ssgh.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("====before======");
    }
    @After("execution(* org.ssgh.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("==========after=========");
    }
    @Around("execution(* org.ssgh.service.UserServiceImpl.*(..))")//在环绕增强中，我们可以定义一个参数，代表我们要获取处理的切入的点
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("====环绕前=========");
        Object proceed = joinPoint.proceed();
        System.out.println("=========环绕后========");
    }
}
