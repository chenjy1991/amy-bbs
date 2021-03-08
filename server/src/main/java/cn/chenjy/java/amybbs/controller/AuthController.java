package cn.chenjy.java.amybbs.controller;

import cn.chenjy.java.amybbs.framework.annotation.Auth;
import cn.chenjy.java.amybbs.framework.annotation.LoginStatus;
import cn.chenjy.java.amybbs.model.request.auth.ActivateAction;
import cn.chenjy.java.amybbs.model.request.auth.ModifyPassword;
import cn.chenjy.java.amybbs.model.request.auth.Reg;
import cn.chenjy.java.amybbs.model.response.CommonResult;
import cn.chenjy.java.amybbs.model.response.auth.ActivateResult;
import cn.chenjy.java.amybbs.model.response.auth.LoginResult;
import cn.chenjy.java.amybbs.model.response.auth.RegResult;
import cn.chenjy.java.amybbs.service.AuthService;
import cn.chenjy.java.amybbs.util.MatchUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
     * 账户注册
     *
     * @param data
     * @return
     */
    @PostMapping("reg")
    @Auth(loginStatus = LoginStatus.LOGOUT)
    public CommonResult reg(@RequestBody Reg data) {
        if (MatchUtils.verifyEmail(data.getEmail())) {
            return RegResult.EmailFormatError();
        }
        if (MatchUtils.verifyPassword(data.getPassword())) {
            return RegResult.PasswordFormatError();
        }
        return authService.reg(data);
    }

    /**
     * 发送账户激活邮件
     *
     * @param userId
     * @return
     */
    @GetMapping("activate/mail")
    public CommonResult sendActivateMail(@RequestHeader("userId") Integer userId) {
        //简单判断userId
        if (userId == 0) {
            return LoginResult.UnfoundError();
        }
        return authService.sendActivateMail(userId);
    }

    /**
     * 激活账户
     *
     * @param data
     * @return
     */
    @PostMapping("activate/action")
    @Auth(loginStatus = LoginStatus.LOGOUT)
    public CommonResult activateAccount(@RequestBody ActivateAction data) {
        //验证检验码
        if (StringUtils.isEmpty(data.getCode())) {
            return ActivateResult.ActivateCodeError();
        }
        return authService.activateAccount(data.getCode());
    }

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
        //校验邮箱地址格式
        if (!MatchUtils.verifyEmail(email)) {
            return LoginResult.EmailFormatError();
        }
        //校验密码格式，大于等于8位，至少英文+数字
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
        //校验密码格式，大于等于8位，至少英文+数字
        if (!MatchUtils.verifyPassword(data.getNewPassword()) || !MatchUtils.verifyPassword(data.getOldPassword())) {
            return LoginResult.PasswordFormatError();
        }
        //简单判断userId
        if (userId == 0) {
            return LoginResult.UnfoundError();
        }
        return authService.modifyPassword(userId, data.getOldPassword(), data.getNewPassword());
    }


}
