package vip.zhangw.onlineeducation.service;

import vip.zhangw.onlineeducation.domain.Video;
import vip.zhangw.onlineeducation.domain.VideoBanner;

import java.util.List;

/**
 * @program: onlineeducation->VideoService
 * @description:
 * @author: zhangwen
 * @create: 2020-08-06 17:29
 **/
public interface VideoService {
    /**
     * 获取视频列表接口
     * @return
     */
    List<Video> videoList();

    /**
     * 首页轮播图的list
     * @return
     */
    List<VideoBanner> bannerList();

    /**
     * 某个视频详情，需要关联章节信息
     * @param videoId
     * @return
     */
    Video findDetailById(int videoId);
}
