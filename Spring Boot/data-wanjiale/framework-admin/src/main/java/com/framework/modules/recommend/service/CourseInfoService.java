package com.framework.modules.recommend.service;

import com.baomidou.mybatisplus.service.IService;
import com.framework.common.utils.PageUtils;
import com.framework.modules.recommend.entity.CourseInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 352256 kB
 *
 * @author MIT
 * @email framework@gmail.com
 * @date 2021-06-06 09:17:03
 */
public interface CourseInfoService extends IService<CourseInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<Integer> getCourseIdList();
    List<CourseInfoEntity> getCourseListById( List<Integer> courseIdList);
}

