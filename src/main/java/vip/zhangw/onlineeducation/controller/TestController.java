package vip.zhangw.onlineeducation.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.zhangw.onlineeducation.util.JsonData;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: onlineeducation->TestController
 * @description: 测试控制器
 * @author: zhangwen
 * @create: 2020-07-23 21:39
 **/
@RestController
@RequestMapping(value = "/api/v1/test")
@PropertySource({"classpath:pay.properties"})
public class TestController {

    @Value("${wxpay.appid}")
    private String payAppid;

    @Value("${wxpay.sercret}")
    private String paySecret;

    @GetMapping(value = "/get_config")
    public Object testConfig(){
        Map<String, Object> map = new HashMap<>();
        map.put("appid", payAppid);
        map.put("secret", paySecret);
        return JsonData.buildSuccess(map);
    }
}
