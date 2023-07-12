package com.yuan.proxy.spring6.bean;

/**
 * @description: 简单工厂模式的工厂类角色。星工厂
 * @author: gbanya
 * @create: 2023-06-13 21:44
 * @Version 1.0
 **/
public class StarFactory {
    //工厂类中有一个静态方法，必须是静态方法
    //简单工厂模式叫做：静态工厂方法模式。

    public static Star getStar(){
        //这个Star对象最终实际上创建的时候还是我们负责new的对象。
        return new Star();
    }

}
