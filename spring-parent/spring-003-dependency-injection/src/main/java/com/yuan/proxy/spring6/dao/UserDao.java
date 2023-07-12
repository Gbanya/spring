package com.yuan.proxy.spring6.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-04 16:32
 * @Version 1.0
 **/
public class UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
    public void insert(){
        // 使用log4j2日志框架
        logger.info("数据库正在保存用户信息");
    }
}
