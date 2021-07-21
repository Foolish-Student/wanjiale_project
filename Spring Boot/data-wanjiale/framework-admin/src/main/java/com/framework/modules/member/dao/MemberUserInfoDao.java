package com.framework.modules.member.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.framework.modules.member.entity.MemberUserInfoEntity;
import com.framework.modules.recommend.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *功能描述
 * @author tangfl
 * @date 2021/6/29
 * @param
 * @return
 */

@Repository
public interface MemberUserInfoDao{
    List<MemberUserInfoEntity> queryPageList( Map<String, Object> reqMap);
    int queryCount( Map<String, Object> reqMap);

    MemberUserInfoEntity selectById(Integer userId);
    int insert(MemberUserInfoEntity memberUserInfoEntity);
    int updateAllColumnById(MemberUserInfoEntity memberUserInfoEntity);
    int deleteBatchIds(@Param("userIds") List<Integer> userIds);
    int enableBatchIds(@Param("userIds")List<Integer> userIds);
    int disableBatchIds(@Param("userIds")List<Integer> userIds);
    int updatePassword(@Param("userId") Integer userId,@Param("password") String password);

    String queryPasswordById(Integer userId);
}
