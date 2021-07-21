package com.framework.modules.recommend.service.impl;

import com.framework.common.exception.RRException;
import com.framework.modules.recommend.dao.UserInfoDao;
import com.framework.modules.recommend.entity.UserInfoEntity;
import com.framework.modules.recommend.service.SysLoginService;
import com.framework.user.SsoService;
import com.framework.user.SsoUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("sysLoginService")
public class SysLoginServiceImpl implements SysLoginService {
    private static final Logger logger = LoggerFactory.getLogger(SysLoginServiceImpl.class);

    @Autowired
    private SsoService ssoService;

    @Autowired
    private UserInfoDao userInfoDao;



    @Override
    public SsoUser doLogin(String username, String password) {
        // 检查用户是否存在
        UserInfoEntity userInfo = userInfoDao.selectUserByUserName(username);
        if (userInfo == null) {
            logger.error("SysLoginServiceImpl...doLogin.username is non-existent");
            throw new RRException("用户不存在或用户状态异常!");
        }

        // 判断密码是否正确
        if (password.equals(userInfo.getPassword())) {
            SsoUser ssoUser = ssoService.createSession(userInfo.getUserId().toString());
            return ssoUser;
        } else {
            logger.error("SysLoginServiceImpl...doLogin.password is wrong");
            throw new RRException("密码不正确!");
        }
    }




    @Override
    public Map<String, String> getUserInfo(String userId) {
        UserInfoEntity userInfo = userInfoDao.selectUserById(userId);
        if (userInfo == null) {
            throw new RRException("获取用户信息异常!");
        }
        Map<String, String> data = new HashMap<>();

        data.put("userId", userInfo.getUserId().toString());
        data.put("userName", userInfo.getUserName().toString());
        data.put("loginName", userInfo.getLoginName());
        data.put("password", userInfo.getPassword());
        return data;
    }
}

