package com.framework.modules.member.service.impl;

import com.framework.modules.member.dao.MemberUserInfoDao;
import com.framework.modules.member.entity.MemberUserInfoEntity;
import com.framework.modules.member.service.MemberUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/*
 *功能描述
 * @author tangfl
 * @description 会员用户service实现类
 * @date 2021-06-29
 */
@Service
public class MemberUserInfoServiceImpl implements MemberUserInfoService {
    @Autowired
    private MemberUserInfoDao memberUserInfoDao;

    @Override
    public List<MemberUserInfoEntity> queryPageList(Map<String, Object> reqMap) {
        return memberUserInfoDao.queryPageList(reqMap);
    }

    @Override
    public int queryCount(Map<String, Object> reqMap) {
        return memberUserInfoDao.queryCount(reqMap);
    }

    @Override
    public MemberUserInfoEntity selectById(Integer userId) {
        return memberUserInfoDao.selectById(userId);
    }

    @Override
    public int insert(MemberUserInfoEntity memberUserInfoEntity) {
        return memberUserInfoDao.insert(memberUserInfoEntity);
    }

    @Override
    public int updateAllColumnById(MemberUserInfoEntity memberUserInfoEntity) {
        return memberUserInfoDao.updateAllColumnById(memberUserInfoEntity);
    }

    @Override
    public int deleteBatchIds(List<Integer> userIds) {
        return memberUserInfoDao.deleteBatchIds(userIds);
    }

    @Override
    public int enableBatchIds(List<Integer> userIds) {
        return memberUserInfoDao.enableBatchIds(userIds);
    }

    @Override
    public int disableBatchIds(List<Integer> userIds) {
        return memberUserInfoDao.disableBatchIds(userIds);
    }

    @Override
    public void updatePassword(Integer userId,String oldPassword,String password) {
        String userPassword = memberUserInfoDao.queryPasswordById(userId);
        if(!userPassword.equals(oldPassword))
            throw new RuntimeException("原密码验证失败");
        else{
            int result = memberUserInfoDao.updatePassword(userId,password);
            if(result != 1)
                throw new RuntimeException("修改失败");
            }
    }
}
