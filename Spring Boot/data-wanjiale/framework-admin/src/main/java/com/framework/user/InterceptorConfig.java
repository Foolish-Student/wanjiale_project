package com.framework.user;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * @author 246419
 * @date 2021-01-27 15:11:53
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(new LoginInterceptor());
        // 添加拦截请求
        ir.addPathPatterns("/**");
        // 添加不拦截路径
        ir.excludePathPatterns(
                "/**/doLogin",          //登录
                "/member/user/**",
                "/member/role/**",//
                "/image/**",//静态图片资源免校验，课程推荐
                "/**/init",//初始化各个表数据
                "/logout"             //框架登出接口
        );
    }
}
