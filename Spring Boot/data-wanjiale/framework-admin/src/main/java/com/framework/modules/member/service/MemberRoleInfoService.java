package com.framework.modules.member.service;


import com.framework.modules.member.entity.MemberRoleInfoEntity;
import com.framework.modules.member.entity.MemberUserInfoEntity;

import java.util.List;
import java.util.Map;

public interface MemberRoleInfoService {
    MemberRoleInfoEntity selectById(Integer roleId);
    int insert(MemberRoleInfoEntity memberRoleInfoEntity);
    int updateAllColumnById(MemberRoleInfoEntity memberRoleInfoEntity);
    int deleteBatchIds(List<Integer> roleIds);
    int enableBatchIds(List<Integer> roleIds);
    int disableBatchIds(List<Integer> roleIds);
    List<MemberRoleInfoEntity> queryPageList(Map<String, Object> reqMap);
    int queryCount( Map<String, Object> reqMap);
}

