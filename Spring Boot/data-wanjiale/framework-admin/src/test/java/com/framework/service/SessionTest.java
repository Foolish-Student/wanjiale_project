package com.framework.service;

import com.framework.common.cache.SessionCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionTest {
    @Autowired
    private SessionCache sessionCache;

    @Test
    public void testSession(){
        sessionCache.setSession("token", "123456");
        System.out.println(sessionCache.getSession("token"));
    }
}
