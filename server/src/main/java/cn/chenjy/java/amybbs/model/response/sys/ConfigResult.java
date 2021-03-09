package cn.chenjy.java.amybbs.model.response.sys;

import cn.chenjy.java.amybbs.model.response.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ChenJY
 * @create 2021/3/9 11:22 上午
 * @DESCRIPTION
 */
public class ConfigResult {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigResult.class);
    private static final String TAG = "ConfigResult";

    /**
     * 参数缺失
     *
     * @return
     */
    public static CommonResult EmptyParams() {
        return CommonResult.ERROR("A0410", "请求必填参数为空");
    }

    /**
     * 参数不被允许
     *
     * @return
     */
    public static CommonResult NotAllowParams() {
        return CommonResult.ERROR("A0420", "请求参数值超出允许的范围");
    }
}
