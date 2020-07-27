package vip.zhangw.onlineeducation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.zhangw.onlineeducation.domain.Video;
import vip.zhangw.onlineeducation.mapper.VideoMapper;
import vip.zhangw.onlineeducation.service.VideoService;

import java.util.List;

/**
 * @program: onlineeducation->VideoServiceImpl
 * @description:
 * @author: zhangwen
 * @create: 2020-07-23 13:48
 **/
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideo() {
        return videoMapper.listVideo();
    }
}
