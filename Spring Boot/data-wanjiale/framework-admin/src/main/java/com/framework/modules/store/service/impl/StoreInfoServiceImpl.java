package com.framework.modules.store.service.impl;

import com.framework.modules.member.entity.MemberRoleInfoEntity;
import com.framework.modules.product.dao.ProductManagementInfoDao;
import com.framework.modules.store.dao.StoreInfoDao;
import com.framework.modules.store.entity.StoreInfoEntity;
import com.framework.modules.store.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: liwan
 * @Description:
 * @Date: create in 2021/7/13 13:34
 */
@Service
public class StoreInfoServiceImpl implements StoreInfoService {
    @Autowired
    private StoreInfoDao storeInfoDao;

    @Override
    public int addStore(StoreInfoEntity storeInfoEntity) {
        return storeInfoDao.addStore(storeInfoEntity);
    }

    @Override
    public int upStore(StoreInfoEntity storeInfoEntity) {
        return storeInfoDao.upStore(storeInfoEntity);
    }

    @Override
    public int delStore(List<Integer> list) {
        return storeInfoDao.delStore(list);
    }

    @Override
    public int start(List<Integer> list) {
        return storeInfoDao.start(list);
    }

    @Override
    public int stop(List<Integer> list) {
        return storeInfoDao.stop(list);
    }


    @Override
    public List<StoreInfoEntity> queryPageList(Map<String, Object> reqMap) {
        System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊"+ reqMap);
        return storeInfoDao.queryPageList(reqMap);
    }

    @Override
    public int queryCount(Map<String, Object> reqMap) {
        return storeInfoDao.queryCount(reqMap);
    }
}
