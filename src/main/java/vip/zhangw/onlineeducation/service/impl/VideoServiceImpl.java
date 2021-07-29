package vip.zhangw.onlineeducation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.zhangw.onlineeducation.config.CacheKeyManager;
import vip.zhangw.onlineeducation.domain.Video;
import vip.zhangw.onlineeducation.domain.VideoBanner;
import vip.zhangw.onlineeducation.mapper.VideoBannerMapper;
import vip.zhangw.onlineeducation.mapper.VideoMapper;
import vip.zhangw.onlineeducation.service.VideoService;
import vip.zhangw.onlineeducation.util.BaseCache;

import java.util.List;

/**
 * @program: onlineeducation->VideoServiceImpl
 * @description:
 * @author: zhangwen
 * @create: 2020-08-06 17:31
 **/
@Service
@Transactional
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private VideoBannerMapper videoBannerMapper;
    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> videoList() {
        try {
            Object cacheObject = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_LIST, ()->{
                List<Video> videoList = videoMapper.selectAll();
                System.out.println("查询数据库");
                return videoList;
            });
            if (cacheObject instanceof List){
                List<Video> videoList = (List<Video>) cacheObject;
                return videoList;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<VideoBanner> bannerList() {
        try {
            Object cacheObject = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, ()->{
                List<VideoBanner> videoBannerList = videoBannerMapper.selectVideoBannerAll();
                return videoBannerList;
            });
            if (cacheObject instanceof List){
                List<VideoBanner> videoBannerList = (List<VideoBanner>) cacheObject;
                return videoBannerList;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video findDetailById(int videoId) {
        try {
            String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAIL, videoId);
            Object cacheObject = baseCache.getOneHourCache().get(videoCacheKey, ()->{
                Video video = videoMapper.findDetailById(videoId);
                return video;
            });
            if (cacheObject instanceof Video){
                Video video = (Video) cacheObject;
                return video;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
