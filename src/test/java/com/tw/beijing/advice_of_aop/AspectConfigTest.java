package com.tw.beijing.advice_of_aop;

import com.tw.beijing.advice_of_aop.bean.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class AspectConfigTest {

    @Autowired
    private User user;

    @BeforeEach
    private void setUp() {
        GlobalInfo.MSG_LIST.clear();
    }
    @Test
    void should_invoke_method_before() {
        user.setUserId();
        assertEquals(2, GlobalInfo.MSG_LIST.size());
        assertEquals(AspectConfig.BEFORE_ADVICE, GlobalInfo.MSG_LIST.get(0));
    }

    @Test
    void should_invoke_method_after_returning() {
        User user1 = user.afterReturning();
        assertEquals(2, GlobalInfo.MSG_LIST.size());
        assertEquals(User.USER_AFTER_RETURNING_JOIN_POINT, GlobalInfo.MSG_LIST.get(0));
        assertEquals(1, user1.getAge());
    }

    @Test
    void should_invoke_method_after_throwing() {
        user.afterThrowing();
    }

    @Test
    void should_invoke_method_after_finally() {
        User user = this.user.afterFinally();
        assertEquals(2, user.getAge());
    }
}