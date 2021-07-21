package com.framework.modules.store.dao;

import com.framework.modules.member.entity.MemberRoleInfoEntity;
import com.framework.modules.store.entity.StoreInfoEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: liwan
 * @Description:
 * @Date: create in 2021/7/13 13:32
 */
@Repository
public interface StoreInfoDao {
    //增加
    int addStore(StoreInfoEntity storeInfoEntity);

    //修改网店
    int upStore(StoreInfoEntity storeInfoEntity);

    //删除网店
    int delStore(List<Integer> list);

    //批量启动
    int start(List<Integer> list);

    //批量禁用
    int stop(List<Integer> list);

    List<StoreInfoEntity> queryPageList(@Param("reqMap") Map<String, Object> reqMap);
    int queryCount( Map<String, Object> reqMap);
}
