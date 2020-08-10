package vip.zhangw.onlineeducation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.zhangw.onlineeducation.domain.Video;
import vip.zhangw.onlineeducation.domain.VideoBanner;

import java.util.List;

public interface VideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    List<Video> selectAll();

    Video findDetailById(int videoId);
}