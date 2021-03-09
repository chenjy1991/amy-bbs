package cn.chenjy.java.amybbs.service;

import cn.chenjy.java.amybbs.model.request.auth.FindbackPassword;
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

    /**
     * 发送账户激活邮件
     *
     * @param userId
     * @return
     */
    CommonResult sendActivateMail(Integer userId);

    /**
     * 激活账户
     *
     * @param code
     * @return
     */
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

    /**
     * 发送找回密码邮件
     *
     * @param email
     * @return
     */
    CommonResult sendFindbackPasswordEmail(String email);

    /**
     * 找回密码
     *
     * @return
     */
    CommonResult findbackPassword(FindbackPassword data);
}
