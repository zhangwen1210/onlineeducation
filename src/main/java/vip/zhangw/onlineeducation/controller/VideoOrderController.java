package vip.zhangw.onlineeducation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.zhangw.onlineeducation.util.JsonData;

/**
 * @program: onlineeducation->VideoOrderController
 * @description:
 * @author: zhangwen
 * @create: 2020-07-25 09:22
 **/
@RestController
@RequestMapping(value = "/api/v1/pri/order")
public class VideoOrderController {

    @RequestMapping(value = "/save")
    public JsonData saveOrder(){

        return JsonData.buildSuccess("下单成功！");
    }
}
