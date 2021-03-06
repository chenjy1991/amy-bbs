package cn.chenjy.java.amybbs.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * @author ChenJY
 * @create 2021/3/7 2:23 上午
 * @DESCRIPTION
 */
public class TimeUtils {
    private static final Logger LOG = LoggerFactory.getLogger(TimeUtils.class);
    private static final String TAG = "TimeUtils";

    public static LocalDateTime getTokenExpireTime(Long expireSecond) {
        LocalDateTime time = LocalDateTime.now();
        return time.plusSeconds(expireSecond);
    }

}
