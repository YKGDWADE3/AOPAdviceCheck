package com.tw.beijing.advice_of_aop.bean;

import com.tw.beijing.advice_of_aop.GlobalInfo;
import org.springframework.stereotype.Component;

@Component
public class User {
    public void setUserId() {
        GlobalInfo.MSG_LIST.add("user set id");
    }

    public User userAfter() {
        GlobalInfo.MSG_LIST.add("user after advice");
        return new User();
    }
}
