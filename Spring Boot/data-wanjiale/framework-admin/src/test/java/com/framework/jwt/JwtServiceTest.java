package com.framework.jwt;

import com.alibaba.fastjson.JSON;
import com.framework.user.SsoService;
import com.framework.user.SsoUser;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtServiceTest {
    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private SsoService ssoService;

    @Test
    public void testToken(){
        String userId = "wanjunjun";
        String token = jwtConfig.createToken(userId);
        System.out.println("---jwt token: "+token);

        String userIdFromToken = jwtConfig.getUsernameFromToken(token);
        System.out.println("----"+userIdFromToken);
    }

    @Test
    public void testCheck(){
        jwtConfig.setExpire(2);//设置2秒后过期
        String userId = "wanjunjun";
        String token = jwtConfig.createToken(userId);
        try {
            Thread.sleep(1000);
//            Claims claims = jwtConfig.getTokenClaim(token);
            System.out.println("---1秒后，is expired:"+jwtConfig.isTokenExpired(token));

            Thread.sleep(2000);
//            claims = jwtConfig.getTokenClaim(token);
            System.out.println("---2秒后，is expired:"+jwtConfig.isTokenExpired(token));
            System.out.println(jwtConfig.getTokenClaim(token));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testSso(){
        String userId = "wanjunjun";
        SsoUser user = ssoService.createSession(userId);
        System.out.println(JSON.toJSONString(user));

        SsoUser currentUser = ssoService.getSession(user.getToken());
        System.out.println(JSON.toJSONString(currentUser));
    }
}
