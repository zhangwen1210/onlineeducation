package vip.zhangw.onlineeducation.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @program: onlineeducation->PlayRecord
 * @description:播放记录表
 * @author: zhangwen
 * @create: 2020-08-11 23:01
 **/
public class PlayRecord {
    private Integer id;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("video_id")
    private Integer videoId;
    @JsonProperty("cerrent_num")
    private Integer currentNum;
    @JsonProperty("episode_id")
    private Integer episodeId;
    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
    private Date createTime;

    public PlayRecord() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Integer currentNum) {
        this.currentNum = currentNum;
    }

    public Integer getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PlayRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", videoId=" + videoId +
                ", currentNum=" + currentNum +
                ", episodeId=" + episodeId +
                ", createTime=" + createTime +
                '}';
    }
}
