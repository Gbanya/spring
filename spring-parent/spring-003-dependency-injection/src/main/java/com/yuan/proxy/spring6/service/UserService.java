package com.yuan.proxy.spring6.service;

import com.yuan.proxy.spring6.dao.UserDao;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-04 16:36
 * @Version 1.0
 **/
public class UserService {

    private UserDao userDao;

    // set注入的话,必须要提供一个set方法
    // Spring容器会调用这个set方法,来给userDao属性赋值


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(){
        //保存用户信息到数据库
        userDao.insert();
    }
}
