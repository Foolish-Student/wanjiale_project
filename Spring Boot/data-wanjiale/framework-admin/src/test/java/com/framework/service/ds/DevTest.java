package com.framework.service.ds;

import com.framework.modules.product.dao.ProductManagementInfoDao;
import com.framework.modules.product.service.ProductManagementInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liwan
 * @Description:
 * @Date: create in 2021/7/13 15:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DevTest {
    @Autowired
    private ProductManagementInfoDao productManagementInfoDao;

    @Autowired
    private ProductManagementInfoService productManagementInfoService;

    @Test
    public void test(){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        int i = productManagementInfoService.delProduct(list);
        System.out.println(i);


    }
}
