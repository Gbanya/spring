package com.yuan.proxy.spring6.bean;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-08 14:23
 * @Version 1.0
 **/

// 如果将value值也不给，bean对象也会有默认的名称：类名首字母小写
@Component
public class User {
    public User() {
        System.out.println("User无参构造方法执行");
    }
}
