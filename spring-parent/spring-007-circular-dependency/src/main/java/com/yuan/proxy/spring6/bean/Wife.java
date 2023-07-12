package com.yuan.proxy.spring6.bean;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-25 20:47
 * @Version 1.0
 **/
public class Wife {
    private String name;

    private Husband husband;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", husband=" + husband.getName() +
                '}';
    }
}
