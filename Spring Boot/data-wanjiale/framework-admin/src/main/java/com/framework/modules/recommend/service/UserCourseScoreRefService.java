package com.framework.modules.recommend.service;

import com.baomidou.mybatisplus.service.IService;
import com.framework.common.utils.PageUtils;
import com.framework.modules.recommend.entity.UserCourseScoreRefEntity;

import java.util.Map;

/**
 * 用户课程评分表; InnoDB free: 352256 kB
 *
 * @author MIT
 * @email framework@gmail.com
 * @date 2021-06-06 09:17:04
 */
public interface UserCourseScoreRefService extends IService<UserCourseScoreRefEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

