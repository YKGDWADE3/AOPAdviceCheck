package com.tw.beijing.advice_of_aop.bean;

import com.tw.beijing.advice_of_aop.GlobalInfo;
import org.springframework.stereotype.Component;

@Component
public class User {
    private int age;

    public void setUserId() {
        GlobalInfo.MSG_LIST.add("user set id");
    }

    public User userAfter() {
        GlobalInfo.MSG_LIST.add("user after advice");
        User user = new User();
        user.setAge(1);
        return user;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
