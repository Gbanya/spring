package com.yuan.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-16 10:04
 * @Version 1.0
 **/

@Component
@Aspect  //切面类是需要@Aspect注解进行标注的
@Order(2)
public class LogAspect {// 通知切面

    // 切面 = 通知 + 切点

    //切点
    private final String point = "@annotation(com.yuan.service.Log)";
    @Pointcut(point)
    public void log(){

    }

    @Around("log()")
    public void aroundFun(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("日志切面环绕增强，前置");
        pjp.proceed(); //执行目标方法
        System.out.println("日志切面环绕增强，后置");
    }

}
