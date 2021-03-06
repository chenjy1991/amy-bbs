package cn.chenjy.java.amybbs.model.response.auth;

import cn.chenjy.java.amybbs.model.response.CommonResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenJY
 * @create 2021/3/6 11:38 下午
 * @DESCRIPTION
 */
public class LoginResult extends CommonResult {
    /**
     * 登陆成功
     *
     * @param info
     * @param token
     * @return
     */
    public static CommonResult OK(LoginInfo info, LoginToken token) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("info", info);
        ret.put("token", token);
        return CommonResult.OK(ret);
    }

    /**
     * 邮箱格式校验失败
     *
     * @return
     */
    public static CommonResult EmailFormatError() {
        return CommonResult.ERROR("A0153", "邮箱格式校验失败");
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
     * 用户不存在
     * @return
     */
    public static CommonResult UnfoundError() {
        return CommonResult.ERROR("A0201", "用户账户不存在");
    }

    /**
     * 用户账户已作废
     *
     * @return
     */
    public static CommonResult DeletedError() {
        return CommonResult.ERROR("A0203", "用户账户已作废");
    }

    public static CommonResult LoginException(){
        return CommonResult.ERROR("A0200","用户登录异常");
    }
}
