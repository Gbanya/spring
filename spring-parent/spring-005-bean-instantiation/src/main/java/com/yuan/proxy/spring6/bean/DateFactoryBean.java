package com.yuan.proxy.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: FactoryBean实战之注入Date
 * @author: gbanya
 * @create: 2023-06-14 21:31
 * @Version 1.0
 **/
public class DateFactoryBean implements FactoryBean<Date> {

    // DateFactoryBean这个工厂Bean协助我们Spring创建这个普通的Bean：Date

    private String strDate;

    public DateFactoryBean(String strDate) {
        this.strDate = strDate;
    }

    @Override
    public Date getObject() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(strDate);
        return date;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
