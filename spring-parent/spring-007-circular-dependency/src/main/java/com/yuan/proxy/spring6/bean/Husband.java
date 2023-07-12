package com.yuan.proxy.spring6.bean;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-25 20:47
 * @Version 1.0
 **/
public class Husband {
    private String name;

    private Wife wife;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife=" + wife.getName() +
                '}';
    }
}
