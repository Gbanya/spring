package com.powernode.myspring.bean;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-25 21:57
 * @Version 1.0
 **/
public class User {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
