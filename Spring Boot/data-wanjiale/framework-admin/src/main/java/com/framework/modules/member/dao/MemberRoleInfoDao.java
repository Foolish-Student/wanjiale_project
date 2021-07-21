package com.framework.modules.member.dao;

import com.framework.modules.member.entity.MemberRoleInfoEntity;
import com.framework.modules.member.entity.MemberUserInfoEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: 表示作者是谁
 * @Description: 描述
 */
@Repository
public interface MemberRoleInfoDao {
    MemberRoleInfoEntity selectById(Integer roleId);
    int insert(MemberRoleInfoEntity memberRoleInfoEntity);
    int updateAllColumnById(MemberRoleInfoEntity memberRoleInfoEntity);
    int deleteBatchIds(@Param("roleIds")List<Integer> roleIds);
    int enableBatchIds(@Param("roleIds")List<Integer> roleIds);
    int disableBatchIds(@Param("roleIds")List<Integer> roleIds);
    List<MemberRoleInfoEntity> queryPageList( Map<String, Object> reqMap);
    int queryCount( Map<String, Object> reqMap);

}
