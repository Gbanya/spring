package com.yuan.spring6.test;

import com.yuan.spring6.bean.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
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

    @Test
    public void testBeanFactory(){
        // ApplicationContext 接口的超级父接口是: BeanFactory(翻译为Bean工厂,就是能够生产Bean对象的一个工厂对象)
        // BeanFactory 是IOC容器的超级接口
        // Spring的IOC容器实际上使用了: 工厂模式
        // Spring底层的IOC是怎么实现的? XML解析 + 工厂模式 + 反射机制
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }

    @Test
    public void testBeginInitBean(){
        //注意: 不是在调用getBean()方法的时候创建对象,执行以下代码的时候就会实例化对象
        new ClassPathXmlApplicationContext("spring.xml");
    }

    @Test
    public void testLog4j(){
        //我们自己如何使用log4j2记录日志信息呢?
        //第一步: 创建日志记录器对象
        //获取FirstSpringTest类的日志记录器对象,也就是说只要FirstSpringTest类中的代码执行记录日志的话,就输出相关的日志信息
        // (当然,也需要看log4j2.xml配置的输出日志的级别是什么)
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);
        logger.debug("debug信息");
        logger.info(("info信息"));
        logger.error("error信息");
    }
}
