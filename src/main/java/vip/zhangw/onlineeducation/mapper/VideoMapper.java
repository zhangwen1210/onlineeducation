package vip.zhangw.onlineeducation.mapper;

import org.springframework.stereotype.Repository;
import vip.zhangw.onlineeducation.domain.Video;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: onlineeducation->VideoMapper
 * @description:
 * @author: zhangwen
 * @create: 2020-07-23 13:23
 **/
@Repository
public class VideoMapper {
    private static Map<Integer, Video> videoMap = new HashMap<>();

    static {
        videoMap.put(1,new Video(1,"Java基础课程，jdk8新特性"));
        videoMap.put(2,new Video(2,"linux基础课程入门到放弃"));
        videoMap.put(3,new Video(3,"SpringBoot入门到精通"));
        videoMap.put(4,new Video(4,"微信支付实战项目"));
        videoMap.put(5,new Video(5,"面试专题第一季"));
    }


    public List<Video> listVideo() {
        List<Video> videoList = new ArrayList<>();
        videoList.addAll(videoMap.values());
        return videoList;
    }
}
