package com.powernode.myspring.bean;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-25 21:59
 * @Version 1.0
 **/
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.insert();
    }
}
