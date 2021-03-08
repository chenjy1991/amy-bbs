package cn.chenjy.java.amybbs.model.response.auth;

import cn.chenjy.java.amybbs.model.response.CommonResult;

/**
 * @author ChenJY
 * @create 2021/3/8 1:24 下午
 * @DESCRIPTION
 */
public class ActivateResult {
    public static CommonResult ActivateCodeError() {
        return CommonResult.ERROR("A0130", "校验码输入错误");
    }

    public static CommonResult UnfountUserError() {
        return CommonResult.ERROR("A0201", "用户账户不存在");
    }

    public static CommonResult ActivatedError() {
        return CommonResult.ERROR("A0506", "用户重复请求");
    }
}
