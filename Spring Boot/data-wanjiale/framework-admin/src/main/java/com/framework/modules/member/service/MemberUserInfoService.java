package com.framework.modules.member.service;

import com.framework.modules.member.entity.MemberUserInfoEntity;

import java.util.List;
import java.util.Map;


public interface MemberUserInfoService {
    List<MemberUserInfoEntity> queryPageList( Map<String, Object> reqMap);
    int queryCount( Map<String, Object> reqMap);

    MemberUserInfoEntity selectById(Integer userId);
    int insert(MemberUserInfoEntity memberUserInfoEntity);
    int updateAllColumnById(MemberUserInfoEntity memberUserInfoEntity);
    int deleteBatchIds(List<Integer> userIds);
    int enableBatchIds(List<Integer> userIds);
    int disableBatchIds(List<Integer> userIds);

    void updatePassword(Integer userId, String oldPassword, String password);
}

