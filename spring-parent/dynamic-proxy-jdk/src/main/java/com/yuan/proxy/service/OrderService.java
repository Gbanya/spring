package com.yuan.proxy.service;

/**
 * @description:  代理对象和目标对象的公共接口
 * @author: gbanya
 * @create: 2023-07-12 21:03
 * @Version 1.0
 **/
public interface OrderService {

    // 生成订单
    void generate();

    // 修改订单信息
    void modify();

    // 查看订单详情
    void detail();
}
