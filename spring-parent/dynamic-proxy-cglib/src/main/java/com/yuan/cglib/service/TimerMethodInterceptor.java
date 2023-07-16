package com.yuan.cglib.service;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-16 09:27
 * @Version 1.0
 **/
public class TimerMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 前置增强
        long begin = System.currentTimeMillis();

        //怎么调用目标对象的目标方法呢
        Object retValue = methodProxy.invokeSuper(target, objects);

        //后置增强
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
        return retValue;
    }
}
