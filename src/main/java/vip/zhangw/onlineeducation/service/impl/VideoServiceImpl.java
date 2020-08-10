package vip.zhangw.onlineeducation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.zhangw.onlineeducation.domain.Video;
import vip.zhangw.onlineeducation.domain.VideoBanner;
import vip.zhangw.onlineeducation.mapper.VideoBannerMapper;
import vip.zhangw.onlineeducation.mapper.VideoMapper;
import vip.zhangw.onlineeducation.service.VideoService;

import java.util.List;

/**
 * @program: onlineeducation->VideoServiceImpl
 * @description:
 * @author: zhangwen
 * @create: 2020-08-06 17:31
 **/
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private VideoBannerMapper videoBannerMapper;

    @Override
    public List<Video> videoList() {
        List<Video> videoList = videoMapper.selectAll();
        return videoList;
    }

    @Override
    public List<VideoBanner> bannerList() {
        List<VideoBanner> videoBannerList = videoBannerMapper.selectVideoBannerAll();
        return videoBannerList;
    }

    @Override
    public Video findDetailById(int videoId) {
        Video video = videoMapper.findDetailById(videoId);
        return video;
    }
}
