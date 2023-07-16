package com.yuan.bank.service;

import com.yuan.bank.pojo.Account;

import java.util.List;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-16 18:22
 * @Version 1.0
 **/
public interface AccountService {
    int save(Account account);
    int deleteByActno(String actno);
    int modify(Account account);
    Account getByActno(String actno);
    List<Account> getAll();
    void transfer(String fromActno,String toActno,double money);
}
