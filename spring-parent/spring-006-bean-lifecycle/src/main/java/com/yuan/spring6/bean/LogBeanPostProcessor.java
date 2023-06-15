package com.yuan.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @description:  日志Bean后处理器
 * @author: gbanya
 * @create: 2023-06-15 21:41
 * @Version 1.0
 **/
public class LogBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行Bean后处理器的before方法。");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /*
    * 方法有两个参数：
    *   第一个参数：刚创建的bean对象
    *   第二个参数：bean对象的名字
     * */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行Bean后处理器的after方法。");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean,beanName);
    }
}
