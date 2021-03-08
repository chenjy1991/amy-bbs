package cn.chenjy.java.amybbs.model.request.auth;

/**
 * @author ChenJY
 * @create 2021/3/8 12:59 下午
 * @DESCRIPTION
 */
public class Reg {
    private String email;
    private String nickname;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
