package com.yuan.service;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-16 10:03
 * @Version 1.0
 **/
@Service
public class UserService { // 目标类

    @SecurityAdvice
    @Log
    public void login(){
        System.out.println("系统正在进行身份验证");
    }
}
