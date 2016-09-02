package com.my.common.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;


public class CacheUtil {

    private static Logger logger = LoggerFactory.getLogger(CacheUtil.class);

    private Cache cache;

    public void setCache(Cache cache) {
        this.cache = cache;
    }


    /**
     * 获取字符串缓存
     *
     * @param key 缓存的key
     * @return 字符串缓存
     */
    public String getString(String key) {
        Object o = get(key);
        if (o == null) {
            return null;
        }
        return String.valueOf(o);
    }

    /**
     * 获得缓存数据
     *
     * @param key 缓存的key
     */
    public Object get(String key) {
        Cache.ValueWrapper vw = cache.get(key);
        if (vw == null) {
            return null;
        }
        return vw.get();
    }

    /**
     * 存数据
     *
     * @param key   缓存的key
     * @param value 缓存的实际值
     */
    public void put(String key, Object value) {
        cache.put(key, value);
    }

    /**
     * 移除缓存
     *
     * @param key 需要移除的缓存的key
     */
    public void remove(String key) {
        cache.evict(key);
    }
}
