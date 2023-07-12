package com.yuan.spring6.bean;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-05 20:57
 * @Version 1.0
 **/
public class Student {

    private String name;
    private Clazz clazz;

    public void setName(String name) {
        this.name = name;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Clazz getClazz() {
        return clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
