package com.yuan.spring6.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-09 10:50
 * @Version 1.0
 **/

@Service
public class OrderService {

    // @Autowired注解使用的时候，不需要指定任何属性值required，直接使用这个注解即可。
    // 这个注解的作用是根据类型ByType进行自动装配
    @Autowired
    @Qualifier("orderDaoImplOrcal")
    private OrderDao orderDao;

    public void generate(){
        orderDao.insert();
    }
}
