package com.tw.beijing.advice_of_aop.bean;

import com.tw.beijing.advice_of_aop.GlobalInfo;
import org.springframework.stereotype.Component;

@Component
public class User {
    public static final String USER_AFTER_RETURNING_JOIN_POINT = "user after returning join point";
    public static final String USER_AFTER_THROWING_JOIN_POINT = "user after throwing join point";
    private int age;

    public User() {

    }

    public User(int age) {
        this.age = age;
    }

    public void setUserId() {
        GlobalInfo.MSG_LIST.add("user set id");
    }

    public User userAfterReturning() {
        GlobalInfo.MSG_LIST.add(USER_AFTER_RETURNING_JOIN_POINT);
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

    public User userAfterThrowing() {
        GlobalInfo.MSG_LIST.add(USER_AFTER_THROWING_JOIN_POINT);
        throw new IllegalArgumentException("user argument illegal");
    }
}
