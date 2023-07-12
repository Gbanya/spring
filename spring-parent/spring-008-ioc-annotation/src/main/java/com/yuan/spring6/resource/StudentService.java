package com.yuan.spring6.resource;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-09 11:17
 * @Version 1.0
 **/

@Service
public class StudentService {
    @Resource(name = "studentDaoImplForOracle")
    private StudentDao studentDao;

    public void deleteStudent(){
        studentDao.deleteById();
    }
}
