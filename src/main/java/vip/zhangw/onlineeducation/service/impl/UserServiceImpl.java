package vip.zhangw.onlineeducation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.zhangw.onlineeducation.domain.User;
import vip.zhangw.onlineeducation.mapper.UserMapper;
import vip.zhangw.onlineeducation.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @program: onlineeducation->UserServiceImpl
 * @description:
 * @author: zhangwen
 * @create: 2020-07-23 13:49
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public static Map<String, User> sessionMap = new HashMap<>();



    @Override
    public String login(String username, String password) {
        User user = userMapper.login(username,password);
        if (user == null){
            return null;
        }else {
            String token = UUID.randomUUID().toString();
            System.out.println(token);
            sessionMap.put(token,user);
            return token;
        }
    }
}
