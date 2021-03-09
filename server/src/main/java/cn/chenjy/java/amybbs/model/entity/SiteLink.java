package cn.chenjy.java.amybbs.model.entity;

import cn.chenjy.java.amybbs.model.request.sys.LinksSave;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * 友情链接
 */
public class SiteLink {
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime updateTime;

    private Boolean isDeleted;

    /**
     * 标题
     */
    private String title;

    /**
     * 链接
     */
    private String url;

    /**
     * 站点描述
     */
    private String summary;

    private String logo;

    public SiteLink() {
    }

    public SiteLink(LinksSave data) {
        this.id = data.getId();
        this.title = data.getTitle();
        this.url = data.getUrl();
        this.summary = data.getSummary();
        this.logo = data.getLogo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}