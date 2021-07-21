package com.framework.modules.recommend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.framework.common.utils.PageUtils;
import com.framework.modules.recommend.dao.UserInfoDao;
import com.framework.modules.recommend.entity.UserInfoEntity;
import com.framework.modules.recommend.service.UserInfoService;
import com.framework.common.utils.Query;


@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserInfoEntity> page = this.selectPage(
                new Query<UserInfoEntity>(params, UserInfoEntity.class).getPage(),
                new EntityWrapper<UserInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Integer> getUserIdList() {
        return userInfoDao.getUserIdList();
    };

}
