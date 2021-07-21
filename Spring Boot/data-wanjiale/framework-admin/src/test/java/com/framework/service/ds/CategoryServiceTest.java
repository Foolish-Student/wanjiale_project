package com.framework.service.ds;

import com.framework.common.utils.SpringContextUtil;
import com.framework.user.SsoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    private SsoService ssoService;



    @Test
    public void testTree(){
        System.out.println("context: "+SpringContextUtil.getApplicationContext());
        System.out.println(ssoService.userId()  +  " loginName:" +  ssoService.loginName());
//        System.out.println(JSON.toJSONString(SpringContextUtil.getApplicationContext().getBean(CategoryService.class).getDatasourceTree()));
    }


}
