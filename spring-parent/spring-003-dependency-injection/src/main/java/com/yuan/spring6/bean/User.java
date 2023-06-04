package com.yuan.spring6.bean;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-04 18:04
 * @Version 1.0
 **/
public class User {
    private String name;// String是简单类型
    private String password;
    private int age;// int是简单类型

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
