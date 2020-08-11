package vip.zhangw.onlineeducation.controller;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.main.client.PrintBandDescriptor;
import vip.zhangw.onlineeducation.domain.VideoOrder;
import vip.zhangw.onlineeducation.service.VideoOrderService;
import vip.zhangw.onlineeducation.util.JsonData;

import javax.servlet.http.HttpServletRequest;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;

/**
 * @program: onlineeducation->VideoOrderController
 * @description:
 * @author: zhangwen
 * @create: 2020-08-11 21:29
 **/
@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {

    @Autowired
    private VideoOrderService videoOrderService;

    @RequestMapping("/save")
    public JsonData saveOrder(@RequestBody Map<String, String> args, HttpServletRequest request){
        // 获取用户ID
        Integer userId = (Integer) request.getAttribute("user_id");
        //
        int rows = videoOrderService.save(args.get("video_id"), userId);

        if (rows == 1){
            return JsonData.buildSuccess();
        }else if (rows == -1){
            return JsonData.buildError("该视频已购买请勿重复购买");
        }else {
            return JsonData.buildError("下单失败");
        }
    }


    @RequestMapping("/list")
    public JsonData listOrder(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");
        List<VideoOrder> videoOrderList = videoOrderService.listOrderByUserId(userId);
        return JsonData.buildSuccess(videoOrderList);
    }


}
