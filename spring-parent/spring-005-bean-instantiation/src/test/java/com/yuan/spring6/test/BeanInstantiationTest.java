package com.yuan.spring6.test;

import com.yuan.spring6.bean.Gun;
import com.yuan.spring6.bean.Person;
import com.yuan.spring6.bean.SpringBean;
import com.yuan.spring6.bean.Star;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-13 21:37
 * @Version 1.0
 **/
public class BeanInstantiationTest {

    //通过构造方法实例化测试
    @Test
    public void testInstantiation1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);
    }

    //通过简单工厂模式实例化测试
    @Test
    public void testInstantiation2(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Star star = applicationContext.getBean("starBean", Star.class);
        System.out.println(star);
    }

    //通过factory-bean实例化
    @Test
    public void testInstantiation3(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Gun gun = applicationContext.getBean("gunBean", Gun.class);
        System.out.println(gun);
    }

    //通过FactoryBean接口实例化
    @Test
    public void testInstantiation4(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person person = applicationContext.getBean("personBean", Person.class);
        System.out.println(person);
    }
}
