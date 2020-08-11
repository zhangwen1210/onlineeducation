package vip.zhangw.onlineeducation.service;

import org.apache.ibatis.annotations.Param;
import vip.zhangw.onlineeducation.domain.VideoOrder;

import java.util.List;

/**
 * @program: onlineeducation->VideoOrderService
 * @description: 视频订单服务层
 * @author: zhangwen
 * @create: 2020-08-11 21:36
 **/
public interface VideoOrderService {

    int save(@Param("video_id") String video_id, @Param("user_id") Integer userId);

    List<VideoOrder> listOrderByUserId(Integer userId);
}
