package com.yuan.spring6;


import com.yuan.spring6.service.CustomerService;
import com.yuan.spring6.service.OrderService;
import com.yuan.spring6.bean.*;
import com.yuan.spring6.jdbc.MyDataSource;
import com.yuan.spring6.jdbc.MyDataSource1;
import com.yuan.spring6.jdbc.MyDataSource2;
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

    // 级联属性赋值
    @Test
    public void testSetDICascade(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("cascade.xml");
        Student studentBean = applicationContext.getBean("studentBean", Student.class);
        System.out.println(studentBean);
    }

    // 注入数组测试
    @Test
    public void testSetDIArray(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-array.xml");
        XiaoMing xiaoMingBean = applicationContext.getBean("xiaoMingBean", XiaoMing.class);
        System.out.println(xiaoMingBean);
    }

    // 注入集合测试
    @Test
    public void testSetDICollection(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-collection.xml");
        Person personBean = applicationContext.getBean("personBean", Person.class);
        System.out.println(personBean);
    }

    // 注入值含有特殊符号测试
    @Test
    public void testSetDISpecial(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MathBean mathBean = applicationContext.getBean("mathBean", MathBean.class);
        System.out.println(mathBean);
    }

    // p命名空间注入测试
    @Test
    public void testSetDIP(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);
        System.out.println(dogBean);
    }

    // 构造注入测试
    @Test
    public void tsetConstructorDI(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
        customerService.save();
    }

    // c命名空间注入测试
    @Test
    public void testSetDIC(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        People peopleBean = applicationContext.getBean("peopleBean", People.class);
        System.out.println(peopleBean);
    }

    // util命名空间注入测试
    @Test
    public void testSetDIUtil(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util.xml");
        MyDataSource1 ds1 = applicationContext.getBean("ds1", MyDataSource1.class);
        MyDataSource2 ds2 = applicationContext.getBean("ds2", MyDataSource2.class);
        System.out.println(ds1);
        System.out.println(ds2);
    }

    // autowire自动装配测试
    @Test
    public void testSetDIAutowire(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        OrderService orderServiceBeanByName = applicationContext.getBean("orderServiceByName", OrderService.class);
        System.out.println(orderServiceBeanByName);

        OrderService orderServiceByType = applicationContext.getBean("orderServiceByType", OrderService.class);
        System.out.println(orderServiceByType);
    }

    // 外部引入properties文件自动装配测试
    @Test
    public void testSetDIProperties(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource ds = applicationContext.getBean("ds", MyDataSource.class);
        System.out.println(ds);
    }
}
