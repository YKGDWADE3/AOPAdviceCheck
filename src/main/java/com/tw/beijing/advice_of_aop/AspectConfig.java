package com.tw.beijing.advice_of_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

    @Before(value = "execution(public void setUserId())")
    public void printInfo(JoinPoint joinPoint) {
        GlobalInfo.MSG_LIST.add("before join point");
    }
}
