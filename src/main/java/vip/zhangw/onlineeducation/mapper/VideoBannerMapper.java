package vip.zhangw.onlineeducation.mapper;

import vip.zhangw.onlineeducation.domain.VideoBanner;

public interface VideoBannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoBanner record);

    int insertSelective(VideoBanner record);

    VideoBanner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VideoBanner record);

    int updateByPrimaryKey(VideoBanner record);
}