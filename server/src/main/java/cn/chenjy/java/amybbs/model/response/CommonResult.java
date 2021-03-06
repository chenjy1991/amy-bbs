package cn.chenjy.java.amybbs.model.response;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @author ChenJY
 * @create 2021/3/6 11:33 下午
 * @DESCRIPTION
 */
public class CommonResult {
    private String errCode;
    private String errMsg;
    private Object data;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime time = LocalDateTime.now();

    public CommonResult() {
    }

    public CommonResult(String errCode, String errMsg, Object data) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = data;
    }

    public static CommonResult OK() {
        return new CommonResult("00000", "success", null);
    }

    public static CommonResult OK(Object data) {
        return new CommonResult("00000", "success", data);
    }

    public static CommonResult ERROR(String errCode, String errMsg) {
        return new CommonResult(errCode, errMsg, null);
    }

    public static CommonResult ERROR(String errCode, String errMsg, Object data) {
        return new CommonResult(errCode, errMsg, data);
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
