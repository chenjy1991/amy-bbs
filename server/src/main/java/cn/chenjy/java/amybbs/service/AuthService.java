package cn.chenjy.java.amybbs.service;

import cn.chenjy.java.amybbs.model.response.CommonResult;

public interface AuthService {

    /**
     * 邮箱登陆,并获取信息
     * @param email
     * @param password
     * @return
     */
    CommonResult loginByEmail(String email,String password);
}
