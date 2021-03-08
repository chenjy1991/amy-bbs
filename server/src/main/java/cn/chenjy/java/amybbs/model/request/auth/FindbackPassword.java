package cn.chenjy.java.amybbs.model.request.auth;

/**
 * @author ChenJY
 * @create 2021/3/8 3:44 下午
 * @DESCRIPTION
 */
public class FindbackPassword {
    private String email;
    private String code;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
