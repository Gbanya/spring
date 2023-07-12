package com.yuan.spring6.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-05 21:28
 * @Version 1.0
 **/
public class Person {
    // 注入List集合
    private List<String> names;

    // 注入set集合
    private Set<String> addrs;

    // 注入map集合
    private Map<Integer,String> phones;

    // 注入属性类对象
    // Properties本质山也是一个map集合
    // Properties的父类Hashtable，Hashtable实现了Map接口
    // Properties虽然也是一个Map集合，和Map的注入方式有点像，但是是不同的。
    // Properties的key和value只能是String类型。
    private Properties properties;

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddrs(Set<String> addrs) {
        this.addrs = addrs;
    }

    public void setPhones(Map<Integer, String> phones) {
        this.phones = phones;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                ", addrs=" + addrs +
                ", phones=" + phones +
                ", properties=" + properties +
                '}';
    }
}
