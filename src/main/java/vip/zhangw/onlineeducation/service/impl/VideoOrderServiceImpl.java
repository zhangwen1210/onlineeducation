package vip.zhangw.onlineeducation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.zhangw.onlineeducation.domain.Episode;
import vip.zhangw.onlineeducation.domain.PlayRecord;
import vip.zhangw.onlineeducation.domain.Video;
import vip.zhangw.onlineeducation.domain.VideoOrder;
import vip.zhangw.onlineeducation.exception.ZdyException;
import vip.zhangw.onlineeducation.mapper.EpisodeMapper;
import vip.zhangw.onlineeducation.mapper.PlayRecordMapper;
import vip.zhangw.onlineeducation.mapper.VideoMapper;
import vip.zhangw.onlineeducation.mapper.VideoOrderMapper;
import vip.zhangw.onlineeducation.service.VideoOrderService;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: onlineeducation->VideoOrderServiceImpl
 * @description:
 * @author: zhangwen
 * @create: 2020-08-11 21:53
 **/
@Service
@Transactional
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private EpisodeMapper episodeMapper;
    @Autowired
    private PlayRecordMapper playRecordMapper;

    @Override
    public int save(String video_id, Integer userId) {
        //先判断是否已购买
        VideoOrder videoOrder = videoOrderMapper.selectByUserIdAndVideoIdAndState(userId, Integer.parseInt(video_id), 1);
        if (videoOrder != null){
            return -1;
        }
        // 查询视频信息
        Video video = videoMapper.selectByPrimaryKey(Integer.parseInt(video_id));
        // 构造视频订单信息
        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoId(video.getId());
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());
        // 保存
        int rows = videoOrderMapper.insertSelective(newVideoOrder);

        if (rows == 1){
            // 生成播放记录信息，先查询视频的第一集信息
            Episode episode = episodeMapper.selectByVideoId(video.getId());
            if (episode == null){
                throw new ZdyException(-1,"没有集信息，请联系运营人员处理");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setUserId(userId);
            playRecord.setVideoId(video.getId());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCreateTime(new Date());
            playRecordMapper.insertPlayRecord(playRecord);
        }
        return rows;
    }

    @Override
    public List<VideoOrder> listOrderByUserId(Integer userId) {
        List<VideoOrder> videoOrderList = videoOrderMapper.listOrderByUserId(userId);
        return videoOrderList;
    }
}
