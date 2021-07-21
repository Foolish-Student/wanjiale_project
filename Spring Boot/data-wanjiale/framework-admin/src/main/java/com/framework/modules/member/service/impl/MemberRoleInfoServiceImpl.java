package com.framework.modules.member.service.impl;

import com.framework.modules.member.dao.MemberRoleInfoDao;
import com.framework.modules.member.entity.MemberRoleInfoEntity;
import com.framework.modules.member.entity.MemberUserInfoEntity;
import com.framework.modules.member.service.MemberRoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 表示作者是谁
 * @Description: 描述会员角色service实现类
 */
@Service
public class MemberRoleInfoServiceImpl implements MemberRoleInfoService {
    @Autowired
    private MemberRoleInfoDao memberRoleInfoDao;

    @Override
    public MemberRoleInfoEntity selectById(Integer roleId) {
        return memberRoleInfoDao.selectById(roleId);
    }

    @Override
    public int insert(MemberRoleInfoEntity memberRoleInfoEntity) {
        return memberRoleInfoDao.insert(memberRoleInfoEntity);
    }
    @Override
    public int updateAllColumnById(MemberRoleInfoEntity memberRoleInfoEntity) {
        return memberRoleInfoDao.updateAllColumnById(memberRoleInfoEntity);
    }
    @Override
    public int deleteBatchIds(List<Integer> roleIds) {
        return memberRoleInfoDao.deleteBatchIds(roleIds);
    }
    @Override
    public int enableBatchIds(List<Integer> roleIds) {
        return memberRoleInfoDao.enableBatchIds(roleIds);
    }

    @Override
    public int disableBatchIds(List<Integer> roleIds) {
        return memberRoleInfoDao.disableBatchIds(roleIds);
    }

    @Override
    public List<MemberRoleInfoEntity> queryPageList(Map<String, Object> reqMap) {
        return memberRoleInfoDao.queryPageList(reqMap);
    }

    @Override
    public int queryCount(Map<String, Object> reqMap) {
        return memberRoleInfoDao.queryCount(reqMap);
    }
}
