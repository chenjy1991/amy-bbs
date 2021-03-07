package cn.chenjy.java.amybbs.model.request.auth;

/**
 * @author ChenJY
 * @create 2021/3/7 9:03 下午
 * @DESCRIPTION
 */
public class ModifyPassword {
    private String newPassword;
    private String oldPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
