package com.yuan.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 *      专门负责计时的一个调用处理器对象。
 *      在这个调用类处理器当中编写计时相关的增强代码。
 *      这个调用处理器只需要写一个就好了。
 *
 * @author: gbanya
 * @create: 2023-07-12 21:40
 * @Version 1.0
 **/
public class TimeInvocationHandler implements InvocationHandler {

    /**
     * 1. 为什么强行要求我们必须实现InvocationHandler接口？
     *     因为一个类实现接口就必须实现接口中的方法。
     *     以下这个方法必须是invoke()，因为JDK在底层调用invoke()方法的程序已经提前写好了。
     *     注意：invoke方法不是我们程序员负责调用的，是JDK负责调用的。
     *
     *  2.invoke方法什么时候调用呢？
     *     当代理对象调用代理方法的时候，注册在InvocationHandler调用处理器当中的invoke()方法被调用。
     *
     *  3.invoke方法的三个参数：
     *      invoke方法是JDK负责调用的，所以JDK调用这个方法的时候就会自动给我们传过来这三个参数。
     *      我们可以在invoke方法的大括号中直接使用：
     *          第一个参数：Object proxy    代理对象的引用，这个参数使用较少
     *          第二个参数：Method method   目标对象里的目标方法。（要执行的目标方法就是它）
     *          第三个参数：Object[] args   目标方法上的实参。
     * */

    private Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //System.out.println("前置增强方法执行...");
        long begin = System.currentTimeMillis();

        // 调用目标对象上的目标方法
        // 方法四要素：哪个对象、哪个方法、传什么参数、返回什么值
        Object retValue = method.invoke(target, args);

        //System.out.println("后置增强方法执行...");
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end-begin) + "毫秒");

        // 注意指责个invoke方法的返回值，如果艾莉对象调用代理方法之后，需要返回结果的话，invoke方法必须将目标对象的目标方法执行结果继续返回。
        return retValue;
    }
}
