package com.framework.modules.recommend.service;

import com.baomidou.mybatisplus.service.IService;
import com.framework.common.utils.PageUtils;
import com.framework.modules.recommend.entity.UserCourseScoreRefEntity;
import com.framework.modules.recommend.entity.UserInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 352256 kB
 *
 * @author MIT
 * @email framework@gmail.com
 * @date 2021-06-06 09:17:04
 */
public interface UserInfoService extends IService<UserInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<Integer>  getUserIdList();
}

