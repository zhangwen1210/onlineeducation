package vip.zhangw.onlineeducation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.zhangw.onlineeducation.domain.User;
import vip.zhangw.onlineeducation.service.UserService;
import vip.zhangw.onlineeducation.util.JsonData;

/**
 * @program: onlineeducation->UserController
 * @description: 用户控制器
 * @author: zhangwen
 * @create: 2020-07-23 20:29
 **/
@RestController
@RequestMapping(value = "/api/v1/pub/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public Object userLogin(@RequestBody User user){
        //System.out.println("username:"+user.getUsername()+" password:"+user.getPassword());
        String token = userService.login(user.getUsername(), user.getPassword());
        return token != null ? JsonData.buildSuccess(token) : JsonData.buildError("账号密码错误！");
    }
}
