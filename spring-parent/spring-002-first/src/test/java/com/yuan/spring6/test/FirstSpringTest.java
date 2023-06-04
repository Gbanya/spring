package com.yuan.spring6.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-04 10:26
 * @Version 1.0
 **/
public class FirstSpringTest {
    @Test
    public void testFirstSpringCode(){
        // 第一步：获取spring容器
        // ApplicationContext 翻译为：应用上下文，其实就是spring容器。
        // ApplicationContext 是一个接口。
        // ApplicationContext 接口下有很多实现类，其中有一个实现类叫做： ClassPathXmlApplicationContext
        // ClassPathXmlApplicationContext 是一个专门从类路径当中加载spring配置文件的spring上下文对象。
        // 这行代码只要执行：就相当于启动了Spring容器，解析了spring.xml配置文件，并且实例化了所有的bean对象并将bean对象放到了Spring容器中。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml","xml/bean.xml");

        // 第二步：根据bean的id从spring容器中获取这个对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

        Object userDaoBean = applicationContext.getBean("userDaoBean");
        System.out.println(userDaoBean);

        Object userBean2 = applicationContext.getBean("userBean2");
        System.out.println(userBean2);

        System.out.println(userBean==userBean2);

        //通过第二个参数指定Spring容器返回bean的类型
        Date nowTime = applicationContext.getBean("nowTime", Date.class);
        //日期格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(nowTime));

        //如果bean的id不存在,不会返回null,而是出现异常
        //Object nowTime2 = applicationContext.getBean("nowTime2");
    }

    @Test
    public void testXmlPath(){
        /*
        * 如果配置文件没有在类路径中,那么如何加载呢?
        *   FileSystemXmlApplicationContext 不是从类路径中加载配置文件
        *   这种方式很少用,了解即可.
        * */
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:/spring-study/spring.xml");
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);
    }

}
