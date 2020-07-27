package vip.zhangw.onlineeducation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.zhangw.onlineeducation.domain.Video;
import vip.zhangw.onlineeducation.service.VideoService;
import vip.zhangw.onlineeducation.util.JsonData;

import java.util.List;

/**
 * @program: onlineeducation->VideoController
 * @description: 视频控制器
 * @author: zhangwen
 * @create: 2020-07-23 13:15
 **/
@RestController
@RequestMapping(value = "/api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    // @RequestMapping(value = "/list", method = RequestMethod.GET)
    @GetMapping(value = "/list")
    public Object list() throws JsonProcessingException {
        List<Video> videoList = videoService.listVideo();
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(videoList);
        System.out.println(str);
        int i = 1/0;
        return JsonData.buildSuccess(videoList);
    }

    @PostMapping("/save_video_chapter")
    public Object saveVideoChapter(@RequestBody Video video){
        System.out.println(video.toString());
        return JsonData.buildSuccess(video);
    }
}
