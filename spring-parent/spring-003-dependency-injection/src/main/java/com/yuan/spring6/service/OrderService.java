package com.yuan.spring6.service;

import com.yuan.spring6.dao.OrderDao;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-04 17:42
 * @Version 1.0
 **/
public class OrderService {

    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate(){
        orderDao.generate();
    }
}
