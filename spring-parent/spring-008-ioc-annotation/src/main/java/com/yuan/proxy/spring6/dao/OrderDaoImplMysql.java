package com.yuan.proxy.spring6.dao;

import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-09 10:51
 * @Version 1.0
 **/

@Repository
public class OrderDaoImplMysql implements OrderDao {
    @Override
    public void insert() {
        System.out.println("Mysql数据库正在保存订单信息...");
    }
}
