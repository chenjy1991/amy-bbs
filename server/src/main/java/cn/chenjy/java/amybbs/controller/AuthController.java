package cn.chenjy.java.amybbs.controller;

import cn.chenjy.java.amybbs.framework.annotation.Auth;
import cn.chenjy.java.amybbs.framework.annotation.LoginStatus;
import cn.chenjy.java.amybbs.model.request.auth.ActivateAction;
import cn.chenjy.java.amybbs.model.request.auth.FindbackPassword;
import cn.chenjy.java.amybbs.model.request.auth.ModifyPassword;
import cn.chenjy.java.amybbs.model.request.auth.Reg;
import cn.chenjy.java.amybbs.model.response.CommonResult;
import cn.chenjy.java.amybbs.model.response.auth.AuthResult;
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
            return AuthResult.EmailFormatError();
        }
        if (MatchUtils.verifyPassword(data.getPassword())) {
            return AuthResult.PasswordFormatError();
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
            return AuthResult.UnfountUserError();
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
            return AuthResult.VerifyCodeError();
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
            return AuthResult.EmailFormatError();
        }
        //校验密码格式，大于等于8位，至少英文+数字
        if (!MatchUtils.verifyPassword(password)) {
            return AuthResult.PasswordFormatError();
        }
        return authService.loginByEmail(email, password);
    }

    /**
     * 修改密码
     *
     * @param data
     * @return
     */
    @PostMapping("password/modify")
    public CommonResult modifyPassword(@RequestBody ModifyPassword data, @RequestHeader("userId") Integer userId) {
        //校验密码格式，大于等于8位，至少英文+数字
        if (!MatchUtils.verifyPassword(data.getNewPassword()) || !MatchUtils.verifyPassword(data.getOldPassword())) {
            return AuthResult.PasswordFormatError();
        }
        //简单判断userId
        if (userId == 0) {
            return AuthResult.UnfountUserError();
        }
        return authService.modifyPassword(userId, data.getOldPassword(), data.getNewPassword());
    }

    /**
     * 发送找回密码邮件
     *
     * @param email
     * @return
     */
    @GetMapping("password/findback/mail")
    @Auth(LoginStatus.LOGOUT)
    public CommonResult getFindbackPasswordEmail(String email) {
        if (!MatchUtils.verifyEmail(email)) {
            return AuthResult.EmailFormatError();
        }
        return authService.sendFindbackPasswordEmail(email);
    }

    /**
     * 找回密码
     *
     * @param data
     * @return
     */
    @PostMapping("password/findback/action")
    @Auth(LoginStatus.LOGOUT)
    public CommonResult findbackPassword(@RequestBody FindbackPassword data) {
        if (!MatchUtils.verifyEmail(data.getEmail())) {
            return AuthResult.EmailFormatError();
        }
        if (StringUtils.isEmpty(data.getCode()) || data.getCode().length() != 8) {
            return AuthResult.VerifyCodeError();
        }
        if (!MatchUtils.verifyPassword(data.getPassword())) {
            return AuthResult.PasswordFormatError();
        }
        return authService.findbackPassword(data);
    }
}
