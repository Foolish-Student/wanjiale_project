package com.framework.user;

import com.alibaba.fastjson.JSONObject;
import com.framework.common.utils.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Web请求拦截器
 *
 * @author 246419
 * @date 2021-01-27 15:11:53
 */
@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        SsoUser ssoUser = SpringContextUtil.getApplicationContext().getBean(SsoService.class).getSession();
//        if (ssoUser != null) {
//            return true;
//        }
//        logger.info("LoginInterceptor...Authorization check failed...");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
//        PrintWriter out;
//        try {
//            JSONObject res = new JSONObject();
//            res.put("code", 999);
//            res.put("msg", "用户未登录");
//            out = response.getWriter();
//            out.append(res.toString());
//            return false;
//        } catch (Exception e) {
//            response.sendError(500);
//            return false;
//        }
//
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//
//    }
}