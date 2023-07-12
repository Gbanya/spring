package com.yuan.proxy.spring6.resource;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-09 11:21
 * @Version 1.0
 **/
@Service
public class StudentDaoImplForOracle implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("Oracle正在删除学生信息...");
    }
}
