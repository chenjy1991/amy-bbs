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
        if (redisService.hasKey(CacheNameConst.BBS_CONF + ConfigKeyConst.REFRESH_TOKEN_EXPIRE)) {
            String val = redisService.get(CacheNameConst.BBS_CONF + ConfigKeyConst.REFRESH_TOKEN_EXPIRE);
            expireSecond = Long.parseLong(val);
        } else {
            BbsConfig config = configMapper.getOneByKey(ConfigKeyConst.REFRESH_TOKEN_EXPIRE);
            if (config != null) {
                expireSecond = Long.parseLong(config.getValue());
                redisService.set(CacheNameConst.BBS_CONF + ConfigKeyConst.REFRESH_TOKEN_EXPIRE, expireSecond + "");
            }
        }
        return expireSecond;
    }

    @Override
    public Long getAccessExpireSeccond() {
        //默认2小时，7200秒
        Long expireSecond = 7200L;
        if (redisService.hasKey(CacheNameConst.BBS_CONF + ConfigKeyConst.ACCESS_TOKEN_EXPIRE)) {
            String val = redisService.get(CacheNameConst.BBS_CONF + ConfigKeyConst.ACCESS_TOKEN_EXPIRE);
            expireSecond = Long.parseLong(val);
        } else {
            BbsConfig config = configMapper.getOneByKey(ConfigKeyConst.ACCESS_TOKEN_EXPIRE);
            if (config != null) {
                expireSecond = Long.parseLong(config.getValue());
                redisService.set(CacheNameConst.BBS_CONF + ConfigKeyConst.ACCESS_TOKEN_EXPIRE, expireSecond + "");
            }
        }
        return expireSecond;
    }

    @Override
    public String getSm4Key() {
        String key = "<chenjy:amy-bbs>";
        if (redisService.hasKey(CacheNameConst.BBS_CONF + ConfigKeyConst.SM4_KEY)) {
            key = redisService.get(CacheNameConst.BBS_CONF + ConfigKeyConst.SM4_KEY);
        } else {
            BbsConfig config = configMapper.getOneByKey(ConfigKeyConst.SM4_KEY);
            if (config != null) {
                key = config.getValue();
                redisService.set(CacheNameConst.BBS_CONF + ConfigKeyConst.SM4_KEY, key);
            }
        }
        return key;
    }

    @Override
    public String getActivateUrl() {
        String url = "http://localhost:8080/activate.html";
        if (redisService.hasKey(CacheNameConst.BBS_CONF + ConfigKeyConst.ACTIVATE_URL)) {
            url = redisService.get(CacheNameConst.BBS_CONF + ConfigKeyConst.ACTIVATE_URL);
        } else {
            BbsConfig config = configMapper.getOneByKey(ConfigKeyConst.ACTIVATE_URL);
            if (config != null) {
                url = config.getValue();
                redisService.set(CacheNameConst.BBS_CONF + ConfigKeyConst.ACTIVATE_URL, url);
            }
        }
        return url;
    }

    @Override
    public String getHomeUrl() {
        String url = "https://github.com/chenjy1991/amy-bbs";
        if (redisService.hasKey(CacheNameConst.BBS_CONF + ConfigKeyConst.HOME_URL)) {
            url = redisService.get(CacheNameConst.BBS_CONF + ConfigKeyConst.HOME_URL);
        } else {
            BbsConfig config = configMapper.getOneByKey(ConfigKeyConst.HOME_URL);
            if (config != null) {
                url = config.getValue();
                redisService.set(CacheNameConst.BBS_CONF + ConfigKeyConst.HOME_URL, url);
            }
        }
        return url;
    }

    @Override
    public String getBbsName() {
        String bbsName = "amy-bbs";
        if (redisService.hasKey(CacheNameConst.BBS_CONF + ConfigKeyConst.BBS_NAME)) {
            bbsName = redisService.get(CacheNameConst.BBS_CONF + ConfigKeyConst.BBS_NAME);
        } else {
            BbsConfig config = configMapper.getOneByKey(ConfigKeyConst.BBS_NAME);
            if (config != null) {
                bbsName = config.getValue();
                redisService.set(CacheNameConst.BBS_CONF + ConfigKeyConst.BBS_NAME, bbsName);
            }
        }
        return bbsName;
    }
}
