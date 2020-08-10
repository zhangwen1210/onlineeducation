package vip.zhangw.onlineeducation.service;

import vip.zhangw.onlineeducation.domain.User;

import java.util.Map;

/**
 * @program: onlineeducation->Userservice
 * @description:
 * @author: zhangwen
 * @create: 2020-08-08 14:24
 **/
public interface Userservice {
    /**
     * 保存用户信息
     * @param userInfo
     * @return
     */
    int saveUser(Map<String, String> userInfo);

    /**
     * 根据手机号查询用户信息
     * @param phone
     * @return
     */
    User findByPhone(String phone);

    /**
     * 根据手机号和密码查询用户
     * @return
     */
    String findByPhoneAndPwd(String phone, String pwd);

    User findByUserId(Integer userId);
}
