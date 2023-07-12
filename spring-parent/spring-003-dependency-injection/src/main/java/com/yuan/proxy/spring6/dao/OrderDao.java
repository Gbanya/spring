package com.yuan.proxy.spring6.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-04 17:40
 * @Version 1.0
 **/
public class OrderDao {

    private static final Logger logger = LoggerFactory.getLogger(OrderDao.class);

    public void generate(){
        logger.info("订单正在生成...");
    }

}
