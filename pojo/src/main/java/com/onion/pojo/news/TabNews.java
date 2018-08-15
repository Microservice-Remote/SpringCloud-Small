package com.onion.pojo.news;

import java.util.Date;
import java.util.List;

/**
 * Created by OnionMac on 2018/5/22.
 */
public class TabNews {

    private int id;
    private int newsType;
    private String title;
    private String source;
    private int comment;
    private int hot;
    private String content;
    private int newsShowType;
    private Date createDate;
    private Date updateDate;

    private List<TabNewsImage> tabImages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNewsType() {
        return newsType;
    }

    public void setNewsType(int newsType) {
        this.newsType = newsType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNewsShowType() {
        return newsShowType;
    }

    public void setNewsShowType(int newsShowType) {
        this.newsShowType = newsShowType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public List<TabNewsImage> getTabImages() {
        return tabImages;
    }

    public void setTabImages(List<TabNewsImage> tabImages) {
        this.tabImages = tabImages;
    }
}
