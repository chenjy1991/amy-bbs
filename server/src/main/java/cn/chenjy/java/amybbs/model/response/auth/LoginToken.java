package cn.chenjy.java.amybbs.model.response.auth;

import cn.chenjy.java.amybbs.model.entity.UserToken;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @author ChenJY
 * @create 2021/3/6 11:48 下午
 * @DESCRIPTION
 */
public class LoginToken {
    private String refreshToken;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime refreshExpire;
    private String accessToken;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime accessExpire;

    public LoginToken(UserToken userToken, String accessToken, LocalDateTime accessExpire) {
        if (userToken != null) {
            this.refreshToken = userToken.getRefreshToken();
            this.refreshExpire = userToken.getRefreshExpire();
        }
        this.accessToken = accessToken;
        this.accessExpire = accessExpire;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public LocalDateTime getRefreshExpire() {
        return refreshExpire;
    }

    public void setRefreshExpire(LocalDateTime refreshExpire) {
        this.refreshExpire = refreshExpire;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public LocalDateTime getAccessExpire() {
        return accessExpire;
    }

    public void setAccessExpire(LocalDateTime accessExpire) {
        this.accessExpire = accessExpire;
    }
}
