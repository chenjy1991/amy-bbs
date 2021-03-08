package cn.chenjy.java.amybbs.service;

import cn.chenjy.java.amybbs.model.request.auth.Reg;
import cn.chenjy.java.amybbs.model.response.CommonResult;

public interface AuthService {

    /**
     * 账户注册
     *
     * @param data
     * @return
     */
    CommonResult reg(Reg data);

    CommonResult sendActivateMail(Integer userId);

    CommonResult activateAccount(String code);

    /**
     * 邮箱登陆,并获取信息
     *
     * @param email
     * @param password
     * @return
     */
    CommonResult loginByEmail(String email, String password);

    /**
     * 修改密码
     *
     * @param userId
     * @param oldPass
     * @param newPass
     * @return
     */
    CommonResult modifyPassword(Integer userId, String oldPass, String newPass);
}
