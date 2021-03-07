package cn.chenjy.java.amybbs.model.entity;

import java.time.LocalDateTime;

/**
 * 用户密钥
 */
public class UserSecret {
    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 密钥类型
     */
    private String secretType;

    /**
     * 密钥id
     */
    private String secretId;

    /**
     * 密钥值
     */
    private String secretKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSecretType() {
        return secretType;
    }

    public void setSecretType(String secretType) {
        this.secretType = secretType;
    }

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}