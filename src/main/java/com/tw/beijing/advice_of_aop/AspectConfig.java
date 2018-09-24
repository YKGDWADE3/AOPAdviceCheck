package com.tw.beijing.advice_of_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

    @Before(value = "execution(public void setUserId())")
    public void beforePrintInfo(JoinPoint joinPoint) {
        GlobalInfo.MSG_LIST.add("before join point");
    }

    @AfterReturning(pointcut = "execution(* *userAfter())", returning = "user")
    public void afterReturning(Object user) {
        GlobalInfo.MSG_LIST.add("after returning join point " + user.getClass());
    }
}
