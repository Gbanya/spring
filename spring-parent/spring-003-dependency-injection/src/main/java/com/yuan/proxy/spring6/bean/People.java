package com.yuan.proxy.spring6.bean;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-05 22:07
 * @Version 1.0
 **/
public class People {
    private String name;
    private int age;
    private boolean sex;

    // c命名空间是简化构造注入的
    // c命名空间注入方法是基于构造方法的
    public People(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
