package cn.chenjy.java.amybbs.util;

import cn.hutool.core.util.ReUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @author ChenJY
 * @create 2021/3/7 12:09 上午
 * @DESCRIPTION
 */
public class MatchUtils {
    private static final Logger LOG = LoggerFactory.getLogger(MatchUtils.class);
    private static final String TAG = "FormatUtils";
    //8位以上，至少包含一个英文和一个数字
    private static final String REGEX_PASSWORD = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,}$";
    private static final String REGEX_MOBILE = "^(?:(?:\\+|00)86)?1(?:(?:3[\\d])|(?:4[5-7|9])|(?:5[0-3|5-9])|(?:6[5-7])|(?:7[0-8])|(?:8[\\d])|(?:9[1|8|9]))\\d{8}$";
    private static final String REGEX_EMAIL = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";

    public static boolean verifyPassword(String password) {
        if (StringUtils.isEmpty(password)) {
            return false;
        }
        return ReUtil.isMatch(REGEX_PASSWORD, password);
    }

    public static boolean verifyMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return false;
        }
        return ReUtil.isMatch(REGEX_MOBILE, mobile);
    }

    public static boolean verifyEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        return ReUtil.isMatch(REGEX_EMAIL, email);
    }
}
