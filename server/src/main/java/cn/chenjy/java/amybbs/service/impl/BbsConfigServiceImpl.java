package cn.chenjy.java.amybbs.service.impl;

import cn.chenjy.java.amybbs.mapper.common.BbsConfigMapper;
import cn.chenjy.java.amybbs.model.constant.CacheNameConst;
import cn.chenjy.java.amybbs.model.constant.ConfigKeyConst;
import cn.chenjy.java.amybbs.model.entity.BbsConfig;
import cn.chenjy.java.amybbs.service.BbsConfigService;
import cn.chenjy.java.amybbs.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenJY
 * @create 2021/3/7 2:10 上午
 * @DESCRIPTION
 */
@Service
public class BbsConfigServiceImpl implements BbsConfigService {
    private static final Logger LOG = LoggerFactory.getLogger(BbsConfigServiceImpl.class);
    private static final String TAG = "BbsConfigService";
    @Autowired
    BbsConfigMapper configMapper;
    @Autowired
    RedisService redisService;

    @Override
    public Long getRefreshExpireSecond() {
        //默认30天，2592000秒
        Long expireSecond = 2592000L;
        if (redisService.hasKey(CacheNameConst.BBS_CONF+ConfigKeyConst.REFRESH_TOKEN_EXPIRE)) {
            String val = redisService.get(CacheNameConst.BBS_CONF+ConfigKeyConst.REFRESH_TOKEN_EXPIRE);
            expireSecond = Long.parseLong(val);
        } else {
            BbsConfig config = configMapper.getOneByKey(ConfigKeyConst.REFRESH_TOKEN_EXPIRE);
            if (config != null) {
                expireSecond = Long.parseLong(config.getValue());
                redisService.set(CacheNameConst.BBS_CONF+ConfigKeyConst.REFRESH_TOKEN_EXPIRE,expireSecond+"");
            }
        }
        return expireSecond;
    }

    @Override
    public Long getAccessExpireSeccond() {
        //默认2小时，7200秒
        Long expireSecond = 7200L;
        if (redisService.hasKey(CacheNameConst.BBS_CONF+ConfigKeyConst.ACCESS_TOKEN_EXPIRE)) {
            String val = redisService.get(CacheNameConst.BBS_CONF+ConfigKeyConst.ACCESS_TOKEN_EXPIRE);
            expireSecond = Long.parseLong(val);
        } else {
            BbsConfig config = configMapper.getOneByKey(ConfigKeyConst.ACCESS_TOKEN_EXPIRE);
            if (config != null) {
                expireSecond = Long.parseLong(config.getValue());
                redisService.set(CacheNameConst.BBS_CONF+ConfigKeyConst.ACCESS_TOKEN_EXPIRE,expireSecond+"");
            }
        }
        return expireSecond;
    }
}
