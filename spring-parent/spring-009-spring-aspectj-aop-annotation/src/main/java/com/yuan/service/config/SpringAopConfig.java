package com.yuan.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-16 15:50
 * @Version 1.0
 **/

@Configuration //代替spring.xml文件
@ComponentScan({"com.yuan.service"}) // 组件扫描
@EnableAspectJAutoProxy // 启用AspectJ的自动代理机制
public class SpringAopConfig {
}
