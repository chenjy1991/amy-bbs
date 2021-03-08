package cn.chenjy.java.amybbs.framework.config;

import cn.chenjy.java.amybbs.model.response.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SysErrorHandler {
    private static final Logger LOG = LoggerFactory.getLogger(SysErrorHandler.class);
    private static final String TAG = "SysErrorHandler";

    @ExceptionHandler
    @ResponseStatus
    public CommonResult runtimeExceptionHandler(Exception e) {
        LOG.error(TAG, e);
        return CommonResult.ERROR("B0001", "系统执行出错");
    }
}
