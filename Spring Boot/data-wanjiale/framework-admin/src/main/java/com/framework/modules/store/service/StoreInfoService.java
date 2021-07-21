package com.framework.modules.store.service;

import com.framework.modules.member.entity.MemberRoleInfoEntity;
import com.framework.modules.store.entity.StoreInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * @Author: liwan
 * @Description:
 * @Date: create in 2021/7/13 13:34
 */
public interface StoreInfoService {
    //增加
    int addStore(StoreInfoEntity storeInfoEntity);

    //修改网店
    int upStore(StoreInfoEntity storeInfoEntity);

    //删除网店
    int delStore(List<Integer> list);

    int start(List<Integer> list);

    int stop(List<Integer> list);


    List<StoreInfoEntity> queryPageList(Map<String, Object> reqMap);
    int queryCount( Map<String, Object> reqMap);
}
