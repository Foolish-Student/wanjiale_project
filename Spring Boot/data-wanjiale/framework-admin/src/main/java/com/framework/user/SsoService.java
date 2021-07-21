package com.framework.user;

import com.framework.common.cache.SessionCache;
import com.framework.common.exception.RRException;
import com.framework.common.utils.ConfigConstant;
import com.framework.jwt.JwtConfig;
import com.framework.modules.recommend.dao.UserInfoDao;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import com.framework.modules.recommend.entity.UserInfoEntity;

@Component
public class SsoService {
    @Autowired
    private SessionCache sessionCache;

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * 返回当前用户id
     */
    public String userId(){
        if (null == getSession()){
            return "";
        }
        return getSession().getUserId();
    }

    /**
     * 返回当前用户登录名
     */
    public String loginName(){
        if (null == getSession()){
            return "";
        }
        return getSession().getLoginName();
    }

    public SsoUser createSession(String userId) {
        SsoUser ssoUser = buildSsoUser(userId, jwtConfig.createToken(userId));
        String cacheKey = DigestUtils.md5DigestAsHex(ssoUser.getToken().getBytes());
        sessionCache.setUser(cacheKey, ssoUser);
        return ssoUser;
    }

    public SsoUser getSession() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader(ConfigConstant.AUTHORIZATION);
        if (StringUtils.isBlank(token)) {
            return null;
        }
        return getSession(token);
    }

    public SsoUser getSession(String token) {
        Claims claims = jwtConfig.getTokenClaim(token);
        if (claims == null) {
            return null;
        }
        String cacheKey = DigestUtils.md5DigestAsHex(token.getBytes());
        SsoUser ssoUser = sessionCache.getUser(cacheKey);
        if (ssoUser != null) {
            return ssoUser;
        } else {
            if (jwtConfig.isTokenExpired(claims.getExpiration())) {
                return null;
            } else {
                ssoUser = buildSsoUser(claims.getSubject(), token);
                sessionCache.setUser(cacheKey, ssoUser);
                return ssoUser;
            }
        }
    }

    private SsoUser buildSsoUser(String userId, String token) {
        SsoUser ssoUser = new SsoUser(userId, token);
        UserInfoEntity userInfo = userInfoDao.selectUserById(userId);
        if (userInfo == null) {
            throw new RRException("创建token失败,用户信息异常!");
        }
        ssoUser.setLoginName(userInfo.getLoginName());
        ssoUser.setUserNameCn(userInfo.getUserName());

        return ssoUser;
    }
}
