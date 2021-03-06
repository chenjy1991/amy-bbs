package cn.chenjy.java.amybbs.model.response.auth;

import cn.chenjy.java.amybbs.model.entity.UserBase;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @author ChenJY
 * @create 2021/3/6 11:40 下午
 * @DESCRIPTION
 */
public class LoginInfo {
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime createTime;
    private String roles;
    private String email;
    private String nickname;
    private String avatar;
    private String backgroundImage;
    private String homePage;
    private String desc;
    private Integer score;
    private Integer topicCount;
    private Integer commentCount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime forbiddenEndTime;

    public LoginInfo() {
    }

    public LoginInfo(UserBase userBase) {
        if (null != userBase) {
            this.userId = userBase.getId();
            this.createTime = userBase.getCreateTime();
            this.roles = userBase.getRoles();
            this.email = userBase.getEmail();
            this.nickname = userBase.getNickname();
            this.avatar = userBase.getAvatar();
            this.backgroundImage = userBase.getBackgroundImage();
            this.homePage = userBase.getHomePage();
            this.desc = userBase.getDesc();
            this.score = userBase.getScore();
            this.topicCount = userBase.getTopicCount();
            this.commentCount = userBase.getCommentCount();
            this.forbiddenEndTime = userBase.getForbiddenEndTime();
        }
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(Integer topicCount) {
        this.topicCount = topicCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public LocalDateTime getForbiddenEndTime() {
        return forbiddenEndTime;
    }

    public void setForbiddenEndTime(LocalDateTime forbiddenEndTime) {
        this.forbiddenEndTime = forbiddenEndTime;
    }
}
