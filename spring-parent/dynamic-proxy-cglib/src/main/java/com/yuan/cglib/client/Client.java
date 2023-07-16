package com.yuan.cglib.client;

import com.yuan.cglib.service.TimerMethodInterceptor;
import com.yuan.cglib.service.Uservice;
import net.sf.cglib.proxy.Enhancer;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-14 19:17
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        // 创建字节码增强器对象
        // 这个对象是CGLIB库当中的核心对象，就是依靠它来生成代理类
        Enhancer enhancer = new Enhancer();

        // 告诉CGLIB父类是谁，告诉CGLIB目标类是谁
        enhancer.setSuperclass(Uservice.class);

        // 设置回调（等同于JDK动态代理中的调用处理器，InvocationHandler）
        // 在CGLIB当中不是InvocationHandler接口，是方法拦截器：是MethodInterceptor
        enhancer.setCallback(new TimerMethodInterceptor());

        // 创建代理对象
        // 这一步会做两件事：
        // 第一件事：在内存中生成Uservice类的子类，这个子类其实就是代理类的字节码
        // 第二件事：创建代理对象
        // 父类是Userservice，子类这个代理类一定是UserService
        Uservice userviceProxy = (Uservice)enhancer.create();

        boolean success = userviceProxy.login("admin", "123");

        System.out.println(success ? "登陆成功" : "登陆失败");

        userviceProxy.logout();
    }
}
