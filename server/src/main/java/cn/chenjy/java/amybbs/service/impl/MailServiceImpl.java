package cn.chenjy.java.amybbs.service.impl;

import cn.chenjy.java.amybbs.service.BbsConfigService;
import cn.chenjy.java.amybbs.service.MailService;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenJY
 * @create 2021/3/8 10:42 上午
 * @DESCRIPTION
 */
@Service
public class MailServiceImpl implements MailService {
    private static final Logger LOG = LoggerFactory.getLogger(MailServiceImpl.class);
    private static final String TAG = "MailServiceImpl";

    @Autowired
    BbsConfigService bbsConfigService;

    @Override
    public void sendRegisterMail(String email, String code) {
        MailAccount account = new MailAccount(MailAccount.MAIL_SETTING_PATHS[0]);
        account.setFrom(bbsConfigService.getBbsName() + "<" + account.getFrom() + ">");
        MailUtil.send(account
                , CollUtil.newArrayList(email)
                , bbsConfigService.getBbsName() + " 账户激活"
                , "<h1>此邮件为官方激活邮件！请点击下面链接完成激活操作！</h1>" +
                        "<h3><a href='" + bbsConfigService.getActivateUrl() + "?code=" + code + "'>激活账户</a></h3>" +
                        "<h2>如果链接无法跳转，请复制以下链接在浏览器中打开</h2><h3><a href='" + bbsConfigService.getActivateUrl() + "?code=" + code + "'>" + bbsConfigService.getActivateUrl() + "?code=" + code + "</a></h3>" +
                        "<h5>此邮件为系统邮件请勿回复，如您想了解更多功能，欢迎访问 <a href='" + bbsConfigService.getHomeUrl() + "'>我们的网站</a> 获取帮助。</h5>"
                , true);
    }

    @Override
    public void sendFindbackPwdMail(String email, String code) {
        MailAccount account = new MailAccount(MailAccount.MAIL_SETTING_PATHS[0]);
        account.setFrom(bbsConfigService.getBbsName() + "<" + account.getFrom() + ">");
        MailUtil.send(account
                , CollUtil.newArrayList(email)
                , bbsConfigService.getBbsName() + " 找回密码验证码"
                , "<h1>以下内容为找回密码验证码，有效期10分钟：</h1>" +
                        "<h2>" + code + "</h2>" +
                        "<h5>此邮件为系统邮件请勿回复，如您想了解更多功能，欢迎访问 <a href='" + bbsConfigService.getHomeUrl() + "'>我们的网站</a> 获取帮助。</h5>"
                , true);
    }


}
