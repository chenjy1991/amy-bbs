package cn.chenjy.java.amybbs.model.response.auth;

import cn.chenjy.java.amybbs.model.response.CommonResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenJY
 * @create 2021/3/8 3:35 下午
 * @DESCRIPTION
 */
public class AuthResult {
    /**
     * 邮箱格式校验失败
     *
     * @return
     */
    public static CommonResult EmailFormatError() {
        return CommonResult.ERROR("A0153", "邮箱格式校验失败");
    }

    /**
     * 密码格式错误
     *
     * @return
     */
    public static CommonResult PasswordFormatError() {
        return CommonResult.ERROR("A0122", "密码强度不够");
    }

    /**
     * 邮箱已存在
     *
     * @return
     */
    public static CommonResult EmailExistedError() {
        return CommonResult.ERROR("A0114", "邮箱已存在");
    }

    /**
     * 用户名已存在
     *
     * @return
     */
    public static CommonResult NicknameExistedError() {
        return CommonResult.ERROR("A0111", "用户名已存在");
    }

    /**
     * 校验码输入错误
     *
     * @return
     */
    public static CommonResult VerifyCodeError() {
        return CommonResult.ERROR("A0130", "校验码输入错误");
    }

    /**
     * 用户账户不存在
     *
     * @return
     */
    public static CommonResult UnfountUserError() {
        return CommonResult.ERROR("A0201", "用户账户不存在");
    }

    /**
     * 用户重复请求
     *
     * @return
     */
    public static CommonResult ActivatedError() {
        return CommonResult.ERROR("A0506", "用户重复请求");
    }

    /**
     * 登陆成功
     *
     * @param info
     * @param token
     * @return
     */
    public static CommonResult LoginOK(LoginInfo info, LoginToken token) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("info", info);
        ret.put("token", token);
        return CommonResult.OK(ret);
    }

    /**
     * 密码错误
     *
     * @return
     */
    public static CommonResult PasswordError() {
        return CommonResult.ERROR("A0210", "用户密码错误");
    }

    /**
     * 用户账户已作废
     *
     * @return
     */
    public static CommonResult DeletedError() {
        return CommonResult.ERROR("A0203", "用户账户已作废");
    }

    /**
     * 用户登录异常
     *
     * @return
     */
    public static CommonResult LoginException() {
        return CommonResult.ERROR("A0200", "用户登录异常");
    }

    /**
     * 访问未授权
     *
     * @return
     */
    public static CommonResult UntokenError() {
        return CommonResult.ERROR("A0301", "访问未授权");
    }

    /**
     * 授权已过期
     *
     * @return
     */
    public static CommonResult TokenExpiredError() {
        return CommonResult.ERROR("A0311", "授权已过期");
    }

    /**
     * 无权限使用API
     *
     * @return
     */
    public static CommonResult UnauthError() {
        return CommonResult.ERROR("A0312", "无权限使用API");
    }

    /**
     * 用户登录已过期
     *
     * @return
     */
    public static CommonResult LoginExpired() {
        return CommonResult.ERROR("A0230", "用户登录已过期");
    }
}
