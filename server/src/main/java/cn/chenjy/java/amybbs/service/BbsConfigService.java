package cn.chenjy.java.amybbs.service;

import cn.hutool.extra.mail.MailAccount;

public interface BbsConfigService {

    Long getRefreshExpireSecond();

    Long getAccessExpireSeccond();

    String getSm4Key();

    String getActivateUrl();

    String getHomeUrl();

    String getBbsName();

    MailAccount getMailConfig();
}
