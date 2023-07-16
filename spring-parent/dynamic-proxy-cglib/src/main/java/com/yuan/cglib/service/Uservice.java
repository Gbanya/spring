package com.yuan.cglib.service;

/**
 * @description: 目标对象
 * @author: gbanya
 * @create: 2023-07-14 19:14
 * @Version 1.0
 **/
public class Uservice {
    // 目标方法
    public boolean login(String username,String password){
        System.out.println("系统正在检验身份...");
        if("admin".equals(username) && "123".equals(password)){
            return true;
        }
        return false;
    }

    // 目标方法
    public void logout(){
        System.out.println("系统正在退出...");
    }
}
