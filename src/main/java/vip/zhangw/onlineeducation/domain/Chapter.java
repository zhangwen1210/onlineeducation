package vip.zhangw.onlineeducation.domain;

import java.io.Serializable;

/**
 * @program: onlineeducation->Chapter
 * @description: 章节对象
 * @author: zhangwen
 * @create: 2020-07-23 20:53
 **/
public class Chapter implements Serializable {
    private Integer id;
    private Integer videoId;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", videoId=" + videoId +
                ", title='" + title + '\'' +
                '}';
    }

    public Chapter() {
    }
}
