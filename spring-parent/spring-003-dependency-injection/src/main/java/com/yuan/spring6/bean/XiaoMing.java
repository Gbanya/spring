package com.yuan.spring6.bean;

import java.util.Arrays;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-05 21:13
 * @Version 1.0
 **/
public class XiaoMing {
    private String[] aihaos;

    private User[] users;

    public void setAihaos(String[] aihaos) {
        this.aihaos = aihaos;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "XiaoMing{" +
                "aihaos=" + Arrays.toString(aihaos) +
                ", users=" + Arrays.toString(users) +
                '}';
    }
}
