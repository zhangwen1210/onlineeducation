package vip.zhangw.onlineeducation.mapper;

import org.apache.ibatis.annotations.Param;
import vip.zhangw.onlineeducation.domain.VideoOrder;

import java.util.List;

public interface VideoOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoOrder record);

    int insertSelective(VideoOrder record);

    VideoOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VideoOrder record);

    int updateByPrimaryKey(VideoOrder record);

    VideoOrder selectByUserIdAndVideoIdAndState(@Param("user_id") int userId, @Param("video_id") int videoId, @Param("state") int state);

    List<VideoOrder> listOrderByUserId(@Param("user_id") Integer userId);
}