package vip.zhangw.onlineeducation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import vip.zhangw.onlineeducation.domain.User;
import vip.zhangw.onlineeducation.service.Userservice;
import vip.zhangw.onlineeducation.util.JsonData;

import javax.servlet.http.HttpServletRequest;
import java.security.PublicKey;
import java.util.Map;

/**
 * @program: onlineeducation->UserController
 * @description: 用户控制层
 * @author: zhangwen
 * @create: 2020-08-08 10:44
 **/
@RestController
@RequestMapping(value = "/api/v1/pri/user")
public class UserController {

    @Autowired
    private Userservice userservice;

    @RequestMapping("/register")
    public JsonData register(@RequestBody Map<String, String> userInfo){
        int rows = userservice.saveUser(userInfo);
        if (rows == 1){
            return JsonData.buildSuccess();
        }else if (rows == 0){
            return JsonData.buildError("手机号已注册！", -1);
        }else if (rows == -2){
            return JsonData.buildError("参数异常！", -2);
        }else {
            return JsonData.buildError("注册未知异常！", -3);
        }
    }


    @PostMapping("/login")
    public JsonData login(@RequestBody Map<String, String> loginInfo){
        String token = userservice.findByPhoneAndPwd(loginInfo.get("phone"), loginInfo.get("pwd"));
        return token == null ? JsonData.buildError("登录失败，账号密码错误") : JsonData.buildSuccess(token);
    }


    @GetMapping("find_by_token")
    public JsonData findUserInfoByToken(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");
        if (userId == null){
            return JsonData.buildError("查询失败");
        }
        User user = userservice.findByUserId(userId);
        return JsonData.buildSuccess(user);
    }


}
