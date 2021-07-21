package com.framework.modules.recommend.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.framework.common.utils.PageUtils;
import com.framework.common.utils.Query;

import com.framework.modules.recommend.dao.UserCourseScoreRefDao;
import com.framework.modules.recommend.entity.UserCourseScoreRefEntity;
import com.framework.modules.recommend.service.UserCourseScoreRefService;


@Service("userCourseScoreRefService")
public class UserCourseScoreRefServiceImpl extends ServiceImpl<UserCourseScoreRefDao, UserCourseScoreRefEntity> implements UserCourseScoreRefService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserCourseScoreRefEntity> page = this.selectPage(
                new Query<UserCourseScoreRefEntity>(params, UserCourseScoreRefEntity.class).getPage(),
                new EntityWrapper<UserCourseScoreRefEntity>()
        );

        return new PageUtils(page);
    }

}
