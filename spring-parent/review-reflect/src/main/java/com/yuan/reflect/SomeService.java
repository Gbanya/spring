package com.yuan.reflect;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-25 21:38
 * @Version 1.0
 **/
public class SomeService {

    public void doSome(){
        System.out.println("public void doSome()执行。");
    }
    public void doSome(String s){
        System.out.println("public void doSome(String s)执行。");
    }
    public void doSome(String s,int i){
        System.out.println("public void doSome(String s,int i)执行。");
    }
}
