package cn.chenjy.java.amybbs.service.impl;

import cn.chenjy.java.amybbs.mapper.common.UserBaseMapper;
import cn.chenjy.java.amybbs.mapper.common.UserSecretMapper;
import cn.chenjy.java.amybbs.mapper.common.UserTokenMapper;
import cn.chenjy.java.amybbs.model.constant.CacheNameConst;
import cn.chenjy.java.amybbs.model.constant.UserSecretTypeConst;
import cn.chenjy.java.amybbs.model.entity.UserBase;
import cn.chenjy.java.amybbs.model.entity.UserSecret;
import cn.chenjy.java.amybbs.model.entity.UserToken;
import cn.chenjy.java.amybbs.model.request.auth.Reg;
import cn.chenjy.java.amybbs.model.response.CommonResult;
import cn.chenjy.java.amybbs.model.response.auth.*;
import cn.chenjy.java.amybbs.service.AuthService;
import cn.chenjy.java.amybbs.service.RedisService;
import cn.chenjy.java.amybbs.service.SecretService;
import cn.chenjy.java.amybbs.util.TimeUtils;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author ChenJY
 * @create 2021/3/6 11:36 下午
 * @DESCRIPTION
 */
@Service
public class AuthServiceImpl implements AuthService {
    private static final Logger LOG = LoggerFactory.getLogger(AuthServiceImpl.class);
    private static final String TAG = "AuthServiceImpl";

    @Autowired
    UserBaseMapper userBaseMapper;
    @Autowired
    UserSecretMapper userSecretMapper;
    @Autowired
    UserTokenMapper userTokenMapper;
    @Autowired
    RedisService redisService;
    @Autowired
    BbsConfigServiceImpl bbsConfigService;
    @Autowired
    SecretService secretService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResult reg(Reg data) {
        //1 验证邮箱及昵称是否重复
        int emailFlag = userBaseMapper.countByEmail(data.getEmail());
        if (emailFlag > 0) {
            return RegResult.EmailExistedError();
        }
        int nicknameFlag = userBaseMapper.countByNickname(data.getNickname());
        if (nicknameFlag > 0) {
            return RegResult.NicknameExistedError();
        }
        //2 创建账户
        UserBase userBase = new UserBase();
        userBase.setEmail(data.getEmail());
        userBase.setNickname(data.getNickname());
        userBaseMapper.insertSelective(userBase);
        UserSecret userSecret = new UserSecret();
        userSecret.setUserId(userBase.getId());
        userSecret.setSecretType(UserSecretTypeConst.PASSWORD);
        userSecret.setSecretId(userBase.getId() + "");
        userSecret.setSecretKey(DigestUtil.md5Hex(data.getPassword() + userBase.getId()));
        userSecretMapper.insertSelective(userSecret);
        return CommonResult.OK();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResult sendActivateMail(Integer userId) {
        UserBase userBase = userBaseMapper.selectByPrimaryKey(userId);
        if (userBase == null) {
            return ActivateResult.UnfountUserError();
        }
        if (!userBase.getIsActivated()) {
            //未激活
            //激活码
            String code = secretService.encodeBySm4(userId + "");
            return CommonResult.OK(code);
        } else {
            return ActivateResult.ActivatedError();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResult activateAccount(String code) {
        Integer userId = Integer.parseInt(secretService.decodeBySm4(code));
        UserBase userBase = userBaseMapper.selectByPrimaryKey(userId);
        if (userBase == null) {
            return ActivateResult.UnfountUserError();
        }
        if (!userBase.getIsActivated()) {
            userBaseMapper.updateIsActivatedById(true, userId);
            return CommonResult.OK();
        } else {
            return ActivateResult.ActivatedError();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResult loginByEmail(String email, String password) {
        UserBase userBase = userBaseMapper.getOneByEmail(email);
        //用户未找到
        if (userBase == null) {
            return LoginResult.UnfoundError();
        }
        /**
         * 已删除
         */
        if (userBase.getIsDeleted()) {
            return LoginResult.DeletedError();
        }
        //判断密码
        UserSecret userSecret = userSecretMapper.getOneByUserIdAndSecretTypeAndSecretId(userBase.getId(), UserSecretTypeConst.PASSWORD, userBase.getId() + "");
        if (userSecret == null) {
            return LoginResult.LoginException();
        }
        //密码错误
        if (!userSecret.getSecretKey().equals(DigestUtil.md5Hex(password + userBase.getId()))) {
            return LoginResult.PasswordError();
        }
        //开始生成登陆信息
        LoginInfo info = new LoginInfo(userBase);
        UserToken userToken = userTokenMapper.getOneByUserId(userBase.getId());
        if (userToken == null) {
            userToken = new UserToken();
            userToken.setUserId(userBase.getId());
            userToken.setRefreshToken(IdUtil.simpleUUID());
            userToken.setRefreshExpire(TimeUtils.getTokenExpireTime(bbsConfigService.getRefreshExpireSecond()));
            userTokenMapper.insertSelective(userToken);
        } else {
            userToken.setRefreshToken(IdUtil.simpleUUID());
            userToken.setRefreshExpire(TimeUtils.getTokenExpireTime(bbsConfigService.getRefreshExpireSecond()));
            userTokenMapper.updateByPrimaryKeySelective(userToken);
        }
        String accessToken = IdUtil.randomUUID();
        LocalDateTime accessExpire = TimeUtils.getTokenExpireTime(bbsConfigService.getAccessExpireSeccond());
        redisService.set(CacheNameConst.USER_TOKEN_ACCESS + accessToken, userBase.getId() + "", bbsConfigService.getAccessExpireSeccond());
        LoginToken token = new LoginToken(userToken, accessToken, accessExpire);
        return LoginResult.OK(info, token);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResult modifyPassword(Integer userId, String oldPass, String newPass) {
        UserSecret userSecret = userSecretMapper.getOneByUserIdAndSecretTypeAndSecretId(userId, UserSecretTypeConst.PASSWORD, userId + "");
        if (userSecret == null) {
            return LoginResult.UnfoundError();
        }
        if (!DigestUtil.md5Hex(oldPass + userId).equals(userSecret.getSecretKey())) {
            return CommonResult.ERROR("A0210", "用户密码错误");
        }
        userSecretMapper.updateSecretKeyById(DigestUtil.md5Hex(newPass + userId), userSecret.getId());
        return CommonResult.OK();
    }
}
