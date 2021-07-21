package com.framework.common.cache;

import com.framework.user.SsoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
public class SessionCache {
    @Autowired
    private  CacheBaseService cacheBaseService;

    @Value("${jwt.expire: 1800}")
    private int expireTime;

    @PostConstruct
    public void init() {
        cacheBaseService.buildLoadingCache(cacheBaseService.GROUP_SESSION, 1, expireTime, TimeUnit.SECONDS, new CacheLoadHandler() {
            @Override
            public Object load(String key) {
                return null;
            }
        });
    }

    public void setSession(String key, String value){
        cacheBaseService.put(cacheBaseService.GROUP_SESSION, key, value);
    }

    public String getSession(String key){
        return cacheBaseService.getLoadingCache(cacheBaseService.GROUP_SESSION, key);
    }

    public void setUser(String key, SsoUser ssoUser){
        cacheBaseService.put(cacheBaseService.GROUP_SESSION, key, ssoUser);
    }

    public SsoUser getUser(String key){
        return cacheBaseService.getLoadingCache(cacheBaseService.GROUP_SESSION, key);
    }
}
