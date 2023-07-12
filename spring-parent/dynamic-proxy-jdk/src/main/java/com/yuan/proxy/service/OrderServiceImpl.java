package com.yuan.proxy.service;

/**
 * @description:  目标对象
 * @author: gbanya
 * @create: 2023-07-12 21:04
 * @Version 1.0
 **/
public class OrderServiceImpl implements OrderService {

    /**
     *  项目经理提出一个新的需求，要统计所有业务接口中每一个业务方法的耗时：
     *  解决方案一：硬编码，在每一个业务接口中的每一个业务方法直接添加统计耗时的程序。
     *  这种方案的缺点：
     *      缺点一：违背OCP开闭原则。
     *      缺点二：代码没有得到复用。（相同的代码写了很多遍）
     *
     *  解决方案二：编写业务类的子类，让子类继承业务类，对每个业务方法进行复写。
     *      缺点一：虽然解决了OCP开闭原则，但是这种方式会导致耦合度很高，因为采用了继承关系，继承关系是一种耦合度非常高的关系，不建议使用。
     *      缺点二：代码没有得到复用。（相同的代码写了很多遍）
     *
     *  解决方案三：代理模式
     *      优点一：解决了OCP问题
     *      优点二：采用代理模式的has a，可以有效降低耦合度。
     *
     *  静态代理的缺点是什么？
     *      类爆炸，假设系统中有1000个接口那么每个接口都需要对应代理类，这样类会急剧膨胀，不好维护。
     *
     *  怎么解决类爆炸问题：
     *      可以使用动态代理解决这个问题。
     * */

    @Override
    public void generate() {// 目标方法
        // 模拟生成订单的耗时
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已生成");
    }

    @Override
    public void modify() {// 目标方法
        // 模拟修改订单的耗时
        try {
            Thread.sleep(456);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已修改");
    }

    @Override
    public void detail() {// 目标方法
        // 查看订单详情
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("查看订单信息");
    }



}
