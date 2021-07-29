package vip.zhangw.onlineeducation.service.impl;

import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.events.Event;
import vip.zhangw.onlineeducation.domain.User;
import vip.zhangw.onlineeducation.mapper.UserMapper;
import vip.zhangw.onlineeducation.service.Userservice;
import vip.zhangw.onlineeducation.util.CommonUtil;
import vip.zhangw.onlineeducation.util.JWTUtils;

import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @program: onlineeducation->Userserviceimpl
 * @description:
 * @author: zhangwen
 * @create: 2020-08-08 14:26
 **/
@Service
@Transactional
public class Userserviceimpl implements Userservice {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(Map<String, String> userInfo) {
        User user = parseToUser(userInfo);
        if (user != null){
            //判断手机号是否已注册
            User is_register = findByPhone(user.getPhone());
            if (is_register == null){
                return userMapper.insertSelective(user);
            }else {
                // 返回0表示手机号已注册
                return 0;
            }
        }else {
            // 参数异常，参数不符合要求
            return -2;
        }
    }

    /**
     * 转换成用户对象
     * @param userInfo
     * @return
     */
    public User parseToUser(Map<String, String> userInfo) {
        if (userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")){
            User user = new User();
            user.setPhone(userInfo.get("phone"));
            user.setName(userInfo.get("name"));
            // 密码需要进行MD5加密
            String pwd = userInfo.get("pwd");
            user.setPwd(CommonUtil.MD5(pwd));
            user.setHeadImg(ramdomHeadImg());
            user.setCreateTime(new Date());
            return user;
        }else {
            return null;
        }
    }

    /**
     * 获取放在CDN上面的随机头像
     * @return
     */
    private static final String ramdomHeadImg () {
        String[] strs ={
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"};
        int size = strs.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return strs[index];
    }

    @Override
    public User findByPhone(String phone) {
        User user = userMapper.findByPhone(phone);
        if (user != null){
            return user;
        }else {
            return null;
        }
    }

    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        User user = userMapper.findByPhoneAndPwd(phone, CommonUtil.MD5(pwd));
        if (user == null ){
            return null;
        }else {
            return JWTUtils.getJsonWebToken(user);
        }
    }

    @Override
    public User findByUserId(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }


}
