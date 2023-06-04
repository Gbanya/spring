package com.yuan.spring6.bean;

/**
 * @description:
 *      这是一个bean，封装了用户的信息
 *
 * @author: gbanya
 * @create: 2023-06-04 10:06
 * @Version 1.0
 **/
public class User {
    /*
    * Spring是怎么实例化对象的呢?
    *   默认情况下Spring会通过反射机制,调用类的无参构造方法来实例化对象,实现原理如下:
    *   class clazz = Class.forName("com.yuan.spring6.bean.User");
    *   clazz.newInstance();
    * */
    public User() {
        System.out.println("User的无参构造执行.");
    }
}
