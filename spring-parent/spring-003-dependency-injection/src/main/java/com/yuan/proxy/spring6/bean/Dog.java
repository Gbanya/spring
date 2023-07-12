package com.yuan.proxy.spring6.bean;

import java.util.Date;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-05 21:59
 * @Version 1.0
 **/
public class Dog {
    //简单类型
    private String name;

    //一般将Date视作非简单类型
    private Date birth;

    // p命名空间注入底层还是set注入，只不过p命名空间注入可以让spring配置变得更加简单
    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                '}';
    }
}
