package com.framework.modules.recommend.service;

import com.framework.user.SsoUser;

import java.util.Map;

/**
 * 用户登录服务
 */
public interface SysLoginService {
    /**
     * 用户登录接口
     */
    SsoUser doLogin(String username, String password);

    /**
     * 获取租户owner详情
     */
    Map<String, String> getUserInfo(String tenantId);
}

