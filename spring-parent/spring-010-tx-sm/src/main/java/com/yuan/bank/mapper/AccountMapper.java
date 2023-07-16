package com.yuan.bank.mapper;

import com.yuan.bank.pojo.Account;

import java.util.List;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-16 17:40
 * @Version 1.0
 **/
public interface AccountMapper {// 接口的实现类不需要写，是mybatis通过动态代理机制生成的实现类

    // 这就是DAO，只要编写CRUD方法即可
    int insert(Account account);
    int deleteByActno(String actno);
    int update(Account account);
    Account selectByActno(String actno);
    List<Account> selectAll();

}
