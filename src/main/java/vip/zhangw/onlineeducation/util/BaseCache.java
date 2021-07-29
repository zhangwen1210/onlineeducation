package vip.zhangw.onlineeducation.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;

/**
 * @program: onlineeducation->BaseCache
 * @description: 缓存
 * @author: zhangwen
 * @create: 2020-08-12 12:47
 **/
@Component
public class BaseCache {

    private Cache<String,Object> tenMinuteCache = CacheBuilder.newBuilder()
            //设置缓存初始⼤大⼩小，应该合理理设置，后续会扩容
            .initialCapacity(10)
            //最⼤大值
            .maximumSize(100)
            //并发数设置
            .concurrencyLevel(5)
            //缓存过期时间，写入后10分钟过期
            .expireAfterWrite(600, TimeUnit.SECONDS)
            //统计缓存命中率
            .recordStats()
            .build();

    public Cache<String, Object> getTenMinuteCache() {
        return tenMinuteCache;
    }
    public void setTenMinuteCache(Cache<String, Object> tenMinuteCache) {
        this.tenMinuteCache = tenMinuteCache;
    }

    private Cache<String,Object> oneHourCache = CacheBuilder.newBuilder()
            //设置缓存初始⼤大⼩小，应该合理理设置，后续会扩容
            .initialCapacity(10)
            //最⼤大值
            .maximumSize(100)
            //并发数设置
            .concurrencyLevel(5)
            //缓存过期时间，写入后1小时过期
            .expireAfterWrite(3600, TimeUnit.SECONDS)
            //统计缓存命中率
            .recordStats()
            .build();

    public Cache<String, Object> getOneHourCache() {
        return oneHourCache;
    }

    public void setOneHourCache(Cache<String, Object> oneHourCache) {
        this.oneHourCache = oneHourCache;
    }
}
