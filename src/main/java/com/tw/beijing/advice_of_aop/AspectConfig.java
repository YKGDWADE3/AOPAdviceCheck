package com.tw.beijing.advice_of_aop;

import com.tw.beijing.advice_of_aop.bean.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

    public static final String BEFORE_ADVICE = "before advice";
    public static final String AFTER_RETURNING_ADVICE = "after returning advice ";
    public static final String AFTER_THROWING_ADVICE = "after throwing advice";

    @Before(value = "execution(public void setUserId())")
    public void beforePrintInfo(JoinPoint joinPoint) {
        GlobalInfo.MSG_LIST.add(BEFORE_ADVICE);
    }

    @AfterReturning(pointcut = "execution(* *userAfterReturning())", returning = "user")
    public User afterReturning(Object user) {
        GlobalInfo.MSG_LIST.add(AFTER_RETURNING_ADVICE + user.getClass());
        return new User();
    }

    @AfterThrowing(pointcut = "execution(* *userAfterThrowing())", throwing = "ex")
    public User afterThrowing(IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
        return new User(1);
    }
}
