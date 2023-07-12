package com.yuan.proxy.spring6.bean;

/**
 * @description: 工厂方法模式当中的：具体工厂模式
 * @author: gbanya
 * @create: 2023-06-13 22:03
 * @Version 1.0
 **/
public class GunFactory {
    //工厂方法模式中的具体工厂角色总的方法是：实例方法
    public Gun getGun(){
        //实际上new这个对象还是我们程序员自己的new的。
        return new Gun();
    }
}
