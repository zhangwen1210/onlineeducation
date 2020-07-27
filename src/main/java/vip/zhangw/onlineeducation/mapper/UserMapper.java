package vip.zhangw.onlineeducation.mapper;

import org.springframework.stereotype.Repository;
import vip.zhangw.onlineeducation.domain.User;
import vip.zhangw.onlineeducation.domain.Video;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: onlineeducation->UserMapper
 * @description:
 * @author: zhangwen
 * @create: 2020-07-23 13:45
 **/
@Repository
public class UserMapper {

    private static Map<String, User> videoMap = new HashMap<>();

    static {
        videoMap.put("zhangw",new User(1,"zhangw","123"));
        videoMap.put("mike",new User(2,"mike","234"));
        videoMap.put("tom",new User(3,"tom","345"));
    }

    public User login(String username, String password) {
        User user = videoMap.get(username);
        if (user == null){
            return null;
        }else {
            if (user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}
