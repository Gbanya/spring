package com.yuan.proxy.spring6.bean;

import java.util.Date;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-14 21:39
 * @Version 1.0
 **/
public class Student {
    private Date birth;

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "birth=" + birth +
                '}';
    }
}
