package com.yuan.util;

import com.yuan.proxy.service.TimeInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-12 22:03
 * @Version 1.0
 **/
public class ProxyUtil {

    public static Object newProxyInstance(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TimeInvocationHandler(target));
    }
}
