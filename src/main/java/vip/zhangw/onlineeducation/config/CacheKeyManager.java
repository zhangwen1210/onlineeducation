package vip.zhangw.onlineeducation.config;

/**
 * @program: onlineeducation->CacheKeyManager
 * @description: 缓存的KEY管理
 * @author: zhangwen
 * @create: 2020-08-12 13:01
 **/
public class CacheKeyManager {
    /**
     * 首页轮播图的缓存key
     */
    public static final String INDEX_BANNER_KEY = "index:banner:list";

    /**
     * 首页视频列表缓存key
     */
    public static final String INDEX_VIDEO_LIST = "index:video:list";

    /**
     * 视频详情缓存key
     */
    public static final String VIDEO_DETAIL = "video:detail:%s";

}
