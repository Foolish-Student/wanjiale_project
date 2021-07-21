package com.framework.modules.recommend.dao;

import com.framework.modules.recommend.entity.UserInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * InnoDB free: 352256 kB
 * 
 * @author MIT
 * @email framework@gmail.com
 * @date 2021-06-06 09:17:04
 */
@Repository
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {

    UserInfoEntity selectUserByUserName(String username);

    UserInfoEntity selectUserById(String userId);

    List<Integer> getUserIdList();
	
}
