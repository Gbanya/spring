package com.yuan.spring6.bean;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-05 21:50
 * @Version 1.0
 **/
public class MathBean {
    private String result;

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MathBean{" +
                "result='" + result + '\'' +
                '}';
    }
}
