package cn.chenjy.java.amybbs.service;

import java.time.LocalDateTime;

public interface BbsConfigService {

    Long getRefreshExpireSecond();
    Long getAccessExpireSeccond();

}
