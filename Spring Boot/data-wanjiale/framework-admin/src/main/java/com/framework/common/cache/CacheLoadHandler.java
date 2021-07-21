package com.framework.common.cache;

public interface CacheLoadHandler<E> {
    E load(String key);

}
