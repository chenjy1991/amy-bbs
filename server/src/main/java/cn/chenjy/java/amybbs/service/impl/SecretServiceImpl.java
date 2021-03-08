package cn.chenjy.java.amybbs.service.impl;

import cn.chenjy.java.amybbs.service.BbsConfigService;
import cn.chenjy.java.amybbs.service.SecretService;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @author ChenJY
 * @create 2021/3/8 3:09 下午
 * @DESCRIPTION
 */
@Service
public class SecretServiceImpl implements SecretService {
    private static final Logger LOG = LoggerFactory.getLogger(SecretServiceImpl.class);
    private static final String TAG = "SecretServiceImpl";

    @Autowired
    BbsConfigService bbsConfigService;

    @Override
    public String encodeBySm4(String key) {
        SymmetricCrypto sm4 = new SymmetricCrypto("SM4", bbsConfigService.getSm4Key().getBytes(StandardCharsets.UTF_8));
        return sm4.encryptHex(key);
    }

    @Override
    public String decodeBySm4(String key) {
        SymmetricCrypto sm4 = new SymmetricCrypto("SM4", bbsConfigService.getSm4Key().getBytes(StandardCharsets.UTF_8));
        return sm4.decryptStr(key);
    }
}
