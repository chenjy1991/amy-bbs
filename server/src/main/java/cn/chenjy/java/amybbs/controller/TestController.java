package cn.chenjy.java.amybbs.controller;

import cn.chenjy.java.amybbs.model.response.CommonResult;
import cn.chenjy.java.amybbs.service.BbsConfigService;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

/**
 * @author ChenJY
 * @create 2021/3/8 2:45 下午
 * @DESCRIPTION
 */
@RestController
@RequestMapping("test")
public class TestController {
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
    private static final String TAG = "TestController";

    @Autowired
    BbsConfigService bbsConfigService;

    @GetMapping("sm4/e")
    public CommonResult encode(String str) {
        SymmetricCrypto sm4 = new SymmetricCrypto("SM4", bbsConfigService.getSm4Key().getBytes(StandardCharsets.UTF_8));
        String encryptHex = sm4.encryptHex(str);
        return CommonResult.OK(encryptHex);
    }

    @GetMapping("sm4/d")
    public CommonResult decode(String str) {
        SymmetricCrypto sm4 = new SymmetricCrypto("SM4", bbsConfigService.getSm4Key().getBytes(StandardCharsets.UTF_8));
        String decryptStr = sm4.decryptStr(str, CharsetUtil.CHARSET_UTF_8);
        return CommonResult.OK(decryptStr);
    }
}
