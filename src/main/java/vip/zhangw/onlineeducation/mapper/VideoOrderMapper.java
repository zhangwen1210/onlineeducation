package vip.zhangw.onlineeducation.mapper;

import vip.zhangw.onlineeducation.domain.VideoOrder;

public interface VideoOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoOrder record);

    int insertSelective(VideoOrder record);

    VideoOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VideoOrder record);

    int updateByPrimaryKey(VideoOrder record);
}