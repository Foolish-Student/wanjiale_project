package com.framework.modules.recommend.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * InnoDB free: 352256 kB
 * 
 * @author MIT
 * @email framework@gmail.com
 * @date 2021-06-06 09:17:04
 */
@TableName("t_user_info")
public class UserInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@TableId(type = IdType.UUID)
	private Integer userId;
	/**
	 * 登录名
	 */
	private String loginName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 设置：用户id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：登录名
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * 获取：登录名
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户名
	 */
	public String getUserName() {
		return userName;
	}
}
