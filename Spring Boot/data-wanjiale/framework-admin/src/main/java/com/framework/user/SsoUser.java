package com.framework.user;

import java.io.Serializable;

public class SsoUser implements Serializable {
    private String userId;      // 用户id
    private String loginName;   // 用户登录名
    private String userNameCn;  // 用户名称
    private String token;


    public SsoUser() {}

    public SsoUser(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserNameCn() {
        return userNameCn;
    }

    public void setUserNameCn(String userNameCn) {
        this.userNameCn = userNameCn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
