package com.yuan.spring6.service;

import com.yuan.spring6.dao.UserDao;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-04 17:15
 * @Version 1.0
 **/
public class CustomerService {
    private UserDao userDao;

    public CustomerService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.insert();
    }
}
