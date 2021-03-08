package cn.chenjy.java.amybbs.controller;

import cn.chenjy.java.amybbs.framework.annotation.Auth;
import cn.chenjy.java.amybbs.framework.annotation.LoginStatus;
import cn.chenjy.java.amybbs.model.request.auth.ModifyPassword;
import cn.chenjy.java.amybbs.model.response.CommonResult;
import cn.chenjy.java.amybbs.model.response.auth.LoginResult;
import cn.chenjy.java.amybbs.service.AuthService;
import cn.chenjy.java.amybbs.util.MatchUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ChenJY
 * @create 2021/3/6 11:31 下午
 * @DESCRIPTION
 */
@RestController
@RequestMapping(value = "auth")
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    private static final String TAG = "AuthController";

    @Autowired
    AuthService authService;

    /**
     * 登陆
     *
     * @param email
     * @param password
     * @return
     */
    @GetMapping("login")
    @Auth(loginStatus = LoginStatus.LOGOUT)
    public CommonResult login(String email, String password) {
        /**
         * 校验邮箱地址格式
         */
        if (!MatchUtils.verifyEmail(email)) {
            return LoginResult.EmailFormatError();
        }
        /**
         * 校验密码格式，大于等于8位，至少英文+数字
         */
        if (!MatchUtils.verifyPassword(password)) {
            return LoginResult.PasswordFormatError();
        }
        return authService.loginByEmail(email, password);
    }

    /**
     * 修改密码
     *
     * @param data
     * @return
     */
    @PostMapping("modifyPassword")
    public CommonResult modifyPassword(@RequestBody ModifyPassword data, @RequestHeader("userId") Integer userId) {
        if (!MatchUtils.verifyPassword(data.getNewPassword()) || !MatchUtils.verifyPassword(data.getOldPassword())) {
            return LoginResult.PasswordFormatError();
        }
        if (userId == 0) {
            return LoginResult.UnfoundError();
        }
        return authService.modifyPassword(userId, data.getOldPassword(), data.getNewPassword());
    }


}
