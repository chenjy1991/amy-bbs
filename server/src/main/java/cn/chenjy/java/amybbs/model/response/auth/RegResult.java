package cn.chenjy.java.amybbs.model.response.auth;

import cn.chenjy.java.amybbs.model.response.CommonResult;

/**
 * @author ChenJY
 * @create 2021/3/8 1:02 下午
 * @DESCRIPTION
 */
public class RegResult {

    public static CommonResult EmailFormatError() {
        return CommonResult.ERROR("A0153", "邮箱格式校验失败");
    }

    public static CommonResult PasswordFormatError() {
        return CommonResult.ERROR("A0122", "密码强度不够");
    }

    public static CommonResult EmailExistedError() {
        return CommonResult.ERROR("A0114", "邮箱已存在");
    }

    public static CommonResult NicknameExistedError() {
        return CommonResult.ERROR("A0111", "用户名已存在");
    }


}
