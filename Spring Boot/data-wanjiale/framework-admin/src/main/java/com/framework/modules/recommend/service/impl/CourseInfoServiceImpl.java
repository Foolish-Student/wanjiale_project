package com.framework.modules.recommend.service.impl;

import com.framework.common.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.framework.common.utils.Query;

import com.framework.modules.recommend.dao.CourseInfoDao;
import com.framework.modules.recommend.entity.CourseInfoEntity;
import com.framework.modules.recommend.service.CourseInfoService;


@Service("courseInfoService")
public class CourseInfoServiceImpl extends ServiceImpl<CourseInfoDao, CourseInfoEntity> implements CourseInfoService {
    @Autowired
    private CourseInfoDao courseInfoDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CourseInfoEntity> page = this.selectPage(
                new Query<CourseInfoEntity>(params, CourseInfoEntity.class).getPage(),
                new EntityWrapper<CourseInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Integer> getCourseIdList() {
        return courseInfoDao.getCourseIdList();
    }

    @Override
    public List<CourseInfoEntity> getCourseListById(List<Integer> courseIdList) {
        return courseInfoDao.getCourseListById(courseIdList);
    }

}
