package com.framework.common.cache;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * 缓存统一管理
 */
@Component
public class CacheBaseService {
    //缓存的组统一写这里
    public static final String GROUP_SESSION = "GROUP_SESSION";
    private static final Map<String, LoadingCache<String, Optional>> loadingCaches = Maps.newHashMap();
//    private static final Map<String, Cache<String, Optional>> caches = Maps.newHashMap();

    /**
     * cache构建
     * expireTime 建议大于refreshTime，这样当缓存在刷新的过程中，可以返回旧值
     * 创建缓存，由业务类去调，这里统一调，会有循环引用
     */
    public void buildLoadingCache(String group, int refreshTime, int expireTime, TimeUnit timeUnit, final CacheLoadHandler cacheLoadHandler) {
        LoadingCache<String, Optional> cache = CacheBuilder.newBuilder()
//                .refreshAfterWrite(refreshTime, timeUnit)// 到了指定时间就刷新，不管有没有访问
                .expireAfterAccess(expireTime, timeUnit)// 给定时间内没有被读/写访问，则回收
                .build(new CacheLoader<String, Optional>() {
                    @Override
                    public Optional load(String s) throws Exception {
                        return Optional.fromNullable(cacheLoadHandler.load(s));
                    }
                });
        loadingCaches.put(group, cache);
    }

//    public void buildCache(String group, int refreshTime, int expireTime, TimeUnit timeUnit){
//        Cache<String, Optional> cache = CacheBuilder.newBuilder()
//                .refreshAfterWrite(refreshTime, timeUnit)// 给定时间内没有被读/写访问，则回收。
//                .expireAfterAccess(expireTime, timeUnit)
//                .build();
//        caches.put(group, cache);
//    }

    public <E> E getLoadingCache(String group, String key) {
        return ((Optional<E>) loadingCaches.get(group).getUnchecked(key)).orNull();
    }

    public <E> void put(String group, String key, E value) {
        LoadingCache<String, Optional> cache = loadingCaches.get(group);
        if (cache != null) {
            cache.put(key, Optional.fromNullable(value));
        }
    }

    public void invalidate(String group, String key) {
        LoadingCache<String, Optional> cache = loadingCaches.get(group);
        if (cache != null) {
            cache.invalidate(key);
        }
    }

    public void invalidate(String group) {
        LoadingCache<String, Optional> cache = loadingCaches.get(group);
        if (cache != null) {
            cache.invalidateAll();
        }
    }

    public void refresh(String group, String key) {
        LoadingCache<String, Optional> cache = loadingCaches.get(group);
        if (cache != null) {
            cache.refresh(key);
        }
    }

    public static void main(String[] args)throws Exception {
        LoadingCache<String, Optional> cache = CacheBuilder.newBuilder()
//                .refreshAfterWrite(3, TimeUnit.SECONDS)// 到了指定时间就刷新，不管有没有访问。
                .expireAfterAccess(300, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Optional>() {
                    @Override
                    public Optional load(String s) throws Exception {
                        return Optional.fromNullable(null);
                    }
                });

        String key = "key";
        cache.put(key, Optional.fromNullable("123"));
        cache.put("key2", Optional.fromNullable("123"));
        cache.put("key3", Optional.fromNullable("abc"));
        ConcurrentMap<String, Optional> map = cache.asMap();
        for (Map.Entry<String, Optional> entry : map.entrySet()){
            System.out.println(entry.getKey()+"-"+entry.getValue().orNull());
        }
        System.out.println(cache.asMap());
        System.out.println(cache.getUnchecked(key).orNull());
        Thread.sleep(2000);
        System.out.println(cache.getUnchecked(key).orNull());
        Thread.sleep(2000);
        System.out.println(cache.getUnchecked(key).orNull());


    }
}
