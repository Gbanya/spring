package com.yuan.proxy.client;

import com.yuan.proxy.service.TimeInvocationHandler;
import com.yuan.proxy.service.OrderService;
import com.yuan.proxy.service.OrderServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-12 21:21
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        // 创建目标对象
        OrderService orderService = new OrderServiceImpl();
        /**
         *  创建代理对象：
         *  1. newProxyInstance 翻译为：新建代理对象
         *      也就是说，通过调用这个方法可以创建代理对象。
         *      本质上，这个Proxy.newProxyInstance()方法的执行，做了两件事：
         *          第一件事：在内存中动态的生成了一个代理类的字节码class
         *          第二件事：new对象了，通过内存中生成的代理类这个代码，实例化了代理对象。
         *
         *  2. 关于newProxyInstance()方法的三个重要的参数，每一个有什么含义，有什么用？
         *      第一个参数：ClassLoader loader
         *          类加载器，这个类加载器有什么作用呢？
         *              在内存中生成的class字节码文件，要执行也得要先加载到jvm内存当中。加载类就需要用到类加载器，所以这里需要指定类加载器。
         *              并且JDK要求，目标类的类加载器必须和代理类的类加载器使用同一个。
         *
         *      第二个参数：Class<?>[] interfaces
         *          代理类和目标类要实现同一个接口或同一些接口。（代理的三要素：目标对象、代理对象、目标对象和代理对象要实现相同的接口。 之一）
         *          在内存中生成代理类的时候，这个代理类是需要你告诉它实现哪些接口的。
         *
         *      第三个参数：InvocationHandler h
         *          InvocationHandler 被翻译为：调用处理器，是一个接口。
         *          在调用处理器接口中编写的是：增强代码
         *          因为具体要增强什么代码，JDK动态代理技术是猜不到的，所以需要我们编写增强代码。
         *          既然InvocationHandler是个接口，那么就需要写接口的实现类。
         *
         *  3. 可能有个疑问，自己动手写调用处理器接口的实现类，难道不会类爆炸吗？
         *      不会，因为这种调用处理器写一次就好。
         *
         *  4. 注意：代理对象和目标对象实现的接口一样，所以可以向下转型
         *
         * */

        OrderService proxyInstance = (OrderService)Proxy.newProxyInstance(orderService.getClass().getClassLoader(), orderService.getClass().getInterfaces(), new TimeInvocationHandler(orderService));
        // 调用代理对象的代理方法
        proxyInstance.generate();

        // 也可以将上面代码封装到一个工具类ProxyUtil中，比较简洁。



    }
}
