package com.yuan.spring6.resource;

import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-09 11:16
 * @Version 1.0
 **/
@Repository
public class StudentDaoImplForMysql implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("Mysql正在删除学生信息...");
    }
}
