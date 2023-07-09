package com.yuan.spring6.dao;

import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-09 10:58
 * @Version 1.0
 **/
@Repository
public class OrderDaoImplOrcal implements OrderDao {
    @Override
    public void insert() {
        System.out.println("Orcal数据库正在保存订单信息...");
    }
}
