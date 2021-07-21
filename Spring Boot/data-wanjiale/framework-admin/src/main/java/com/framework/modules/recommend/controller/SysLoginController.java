package com.framework.modules.recommend.controller;

import com.framework.common.utils.ConfigConstant;
import com.framework.common.utils.R;
import com.framework.modules.recommend.service.SysLoginService;
import com.framework.user.SsoUser;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 登录相关
 */
@Controller
public class SysLoginController {
	private static final Logger logger = LoggerFactory.getLogger(SysLoginController.class);

	@Autowired
	private SysLoginService sysLoginService;

	/**
	 * 自定义登录接口
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/doLogin", method = RequestMethod.POST)
	public R doLogin(@RequestBody Map<String, Object> param) {
		logger.info("SysLoginController...sys.doLogin()...");
		if (CollectionUtils.isEmpty(param)) {
			return R.error("参数不能为空!");
		}
		String username = String.valueOf(param.get("username"));
		String password = String.valueOf(param.get("password"));
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			return R.error("用户名或密码不能为空");
		}
		SsoUser ssoUser = sysLoginService.doLogin(username, password);

		return R.ok()
				.put("userId", ssoUser.getUserId())
				.put("loginName", ssoUser.getLoginName())
				.put("userNameCn", ssoUser.getUserNameCn())
				.put(ConfigConstant.AUTHORIZATION, ssoUser.getToken());
	}



	/**
	 * 获取用户详情
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/getUserInfo", method = RequestMethod.POST)
	public R getUserInfo(@RequestBody Map<String, Object> param) {
		logger.info("SysLoginController...sys.getUserInfo()...");
		if (CollectionUtils.isEmpty(param)) {
			return R.error("参数不能为空!");
		}

		// String userId
		String userId = String.valueOf(param.get("userId"));
		if (StringUtils.isEmpty(userId)) {
			return R.error("userId不能为空!");
		}
		Map<String, String> data = sysLoginService.getUserInfo(userId);
		return R.ok().put("data", data);
	}

	@ResponseBody
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public R hello() {
		logger.info("SysLoginController...hello()...");
		return R.ok().put("data", "hello world!");
	}

}
