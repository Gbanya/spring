package com.yuan.bank.pojo;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-07-16 17:38
 * @Version 1.0
 **/
public class Account {
    private String actno;
    private Double balance;

    public Account() {
    }

    public Account(String actno, Double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "actno='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }
}
