package com.yuan.spring6.bean;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-05 20:57
 * @Version 1.0
 **/
public class Clazz {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "name='" + name + '\'' +
                '}';
    }
}
