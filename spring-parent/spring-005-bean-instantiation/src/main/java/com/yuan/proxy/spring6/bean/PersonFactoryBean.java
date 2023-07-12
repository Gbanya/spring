package com.yuan.proxy.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-13 22:22
 * @Version 1.0
 **/
public class PersonFactoryBean implements FactoryBean<Person> {
    //PersonFactoryBean也是一个Bean，只不过这个Bean有点特殊，叫做工厂Bean。
    //通过工厂Bean这个特殊的Bean对象，我们可以获取一个普通的Bean。
    @Override
    public Person getObject() throws Exception {
        //最终这个Bean的创建还是我们程序员创建的。
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    //这个方法在接口中有默认实现。
    //默认返回true，表示单例的，如果想多例，return false即可。
    @Override
    public boolean isSingleton() {
        return false;
    }
}
