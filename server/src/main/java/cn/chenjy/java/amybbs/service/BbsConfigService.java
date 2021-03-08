package cn.chenjy.java.amybbs.service;

public interface BbsConfigService {

    Long getRefreshExpireSecond();

    Long getAccessExpireSeccond();

    String getSm4Key();

    String getActivateUrl();

    String getHomeUrl();

    String getBbsName();
}
