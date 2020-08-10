package vip.zhangw.onlineeducation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vip.zhangw.onlineeducation.domain.Video;
import vip.zhangw.onlineeducation.domain.VideoBanner;
import vip.zhangw.onlineeducation.service.VideoService;
import vip.zhangw.onlineeducation.util.JsonData;

import java.util.List;

/**
 * @program: onlineeducation->VideoController
 * @description:
 * @author: zhangwen
 * @create: 2020-08-06 17:12
 **/
@RestController
@RequestMapping(value = "/api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 首页轮播图
     * @return
     */
    @RequestMapping(value = "/list_banner")
    public JsonData indexBanner(){
        List<VideoBanner> videoBannerList = videoService.bannerList();
        return JsonData.buildSuccess(videoBannerList);
    }

    /**
     * 视频信息
     * @return
     */
    @RequestMapping(value = "/list")
    public JsonData videoList(){
        List<Video> videoList = videoService.videoList();
        return JsonData.buildSuccess(videoList);
    }


    @RequestMapping(value = "/find_detail_by_id")
    public JsonData findDetailById(@RequestParam(value = "video_id", required = true) int videoId){
        Video video = videoService.findDetailById(videoId);
        return JsonData.buildSuccess(video);
    }

}
