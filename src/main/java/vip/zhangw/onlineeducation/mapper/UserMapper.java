package vip.zhangw.onlineeducation.mapper;

import org.apache.ibatis.annotations.Param;
import vip.zhangw.onlineeducation.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByPhone(String phone);

    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);
}