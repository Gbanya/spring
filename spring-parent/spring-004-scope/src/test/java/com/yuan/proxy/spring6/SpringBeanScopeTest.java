package com.yuan.proxy.spring6;

import com.yuan.proxy.spring6.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-06 22:25
 * @Version 1.0
 **/
public class SpringBeanScopeTest {

    //多例以及单例作用域测试
    @Test
    public void tsetBeanScope(){

        /*
        *   1.Spring默认情况下是如何管理Bean的：
        *       默认情况下Bean是单例的。
        *       在Spring上下文初始化的时候实例化：new ClassPathXmlApplicationContext("spring-scope.xml")
        *       每一次调用getBean() 方法的时候，都返回那个单例的对象。
        *
        *   2.当bean的scope属性设置为prototype时：
        *       bean是多例的。
        *       spring上下文初始化的时候，并不会初始化这些prototype的bean。（和单例不同）
        *       每一次调用getBean()的时候，实例化该对象的bean对象。
        *       prototype翻译为：原型
        * */
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb1);
        SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb2);
        SpringBean sb3 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb3);
    }

    //自定义作用域测试：不同线程的bean对象不同
    @Test
    public void testThreadScope(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println("sb:"+sb);
        SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println("sb1:"+sb1);

        // 启动一个新的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                SpringBean sb2= applicationContext.getBean("sb", SpringBean.class);
                System.out.println("sb2:"+sb2);
                SpringBean sb3= applicationContext.getBean("sb", SpringBean.class);
                System.out.println("sb3:"+sb3);

            }
        }).start();


        System.out.println("------------下面的就是同一个线程内的bean对象是同一个-----------");

        SpringBean sb4 = applicationContext.getBean("sbThreadBean", SpringBean.class);
        System.out.println("sb4:"+sb4);
        SpringBean sb5 = applicationContext.getBean("sbThreadBean", SpringBean.class);
        System.out.println("sb5:"+sb5);

        // 启动一个新的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                SpringBean sb6= applicationContext.getBean("sbThreadBean", SpringBean.class);
                System.out.println("sb6:"+sb6);
                SpringBean sb7= applicationContext.getBean("sbThreadBean", SpringBean.class);
                System.out.println("sb7:"+sb7);

            }
        }).start();
    }
}
