package com.yuan.spring6;

import com.yuan.spring6.bean.User;
import com.yuan.spring6.service.CustomerService;
import com.yuan.spring6.service.OrderService;
import com.yuan.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-04 16:46
 * @Version 1.0
 **/
public class SpringDTTest {

    // set注入测试
    @Test
    public void testSetDI(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.saveUser();
    }

    // 外部bean以及内部bean set注入测试
    @Test
    public void testSetDIOutAndInner(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        OrderService orderServiceBean = applicationContext.getBean("orderServiceBean", OrderService.class);
        orderServiceBean.generate();

        OrderService orderServiceBean2 = applicationContext.getBean("orderServiceBean2", OrderService.class);
        orderServiceBean2.generate();
    }

    // 简单类型set注入测试
    @Test
    public void tsetSetDISimp(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    // 构造注入测试
    @Test
    public void tsetConstructorDI(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
        customerService.save();
    }
}
