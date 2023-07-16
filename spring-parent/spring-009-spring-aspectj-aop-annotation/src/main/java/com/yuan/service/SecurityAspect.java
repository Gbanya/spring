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
 * @create: 2023-07-16 15:21
 * @Version 1.0
 **/

@Component
@Aspect
@Order(3) // 数字越小，优先级越高
public class SecurityAspect { // 安全切面
    // 切点
    private final String point = "@annotation(com.yuan.service.SecurityAdvice)";
    @Pointcut(point)
    public void securityPoint(){}

    // 安全增强
    @Around("securityPoint()")
    public void aroundFun(ProceedingJoinPoint pjp) throws Throwable {
        /**
         *  1. ProceedingJoinPoint pjp,在spring容器中调用这个方法的时候自动传过来，我们可以直接使用
         *  2. 这个ProceedingJoinPoint类型参数的作用是什么？
         *      ·pjp.getSignature()：获取目标方法的签名，为：com.yuan.service.UserService.login()
         *      ·pjp.getSignature()，通过这个方法的签名我们可以获取到该方法的具体信息，例如目标的方法名：pjp.getSignature().getName()
         *
         * */

        System.out.println("getSignature"+pjp.getSignature().getName());
        System.out.println("安全切面环绕增强,前置");
        pjp.proceed(); // 执行目标方法
        System.out.println("安全切面环绕增强,后置");
    }

}
