package vip.zhangw.onlineeducation.mapper;

import org.apache.ibatis.annotations.Param;
import vip.zhangw.onlineeducation.domain.Episode;

public interface EpisodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Episode record);

    int insertSelective(Episode record);

    Episode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Episode record);

    int updateByPrimaryKey(Episode record);

    Episode selectByVideoId(@Param("video_id") Integer video_id);
}