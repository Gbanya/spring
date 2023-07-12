package com.yuan.proxy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 自定义一个@Component注解
 * @author: gbanya
 * @create: 2023-07-08 09:18
 * @Version 1.0
 **/


//标注注解的注解，叫做元注解。
//使用某个注解的时候，如果注解的属性名是value的话，value可以省略。
//如果注解的属性值是数组，并且数组中只有一个元素，大括号可以省略。

@Target(ElementType.TYPE)//@Target是元注解，@Target注解用来修饰@Component注解可以出现的位置
/*
1..RetentionPolicy.SOURCE表示@Component注解只保留在.java文件中，编译后的class文件不存在了。
2.RetentionPolicy.CLASS表示@Component注解可以保留在.java文件中，并且编译后的class文件中也存在。
3.RetentionPolicy.RUNTIME表示@Component注解最终保留在class文件中，并且可以被反射机制读取。
 */

@Retention(RetentionPolicy.RUNTIME)//@Retention是元注解。
public @interface Component {
    // 定义注解的属性
    // String是属性类型
    // value是属性
    String value();

    // 数组属性
    // 属性类型是：String[]
    // 属性名：names
    //String[] names();
}
