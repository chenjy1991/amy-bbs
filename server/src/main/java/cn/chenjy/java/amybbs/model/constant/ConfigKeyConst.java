package cn.chenjy.java.amybbs.model.constant;

import java.util.Arrays;
import java.util.List;

/**
 * @author ChenJY
 * @create 2021/3/7 2:21 上午
 * @DESCRIPTION
 */
public class ConfigKeyConst {

    public static final List<String> KEYS = Arrays.asList("refresh_token_expire", "access_token_expire", "sm4_key", "site_url_activate", "site_url_home", "bbs_name", "mail_config");

    public static final String REFRESH_TOKEN_EXPIRE = "refresh_token_expire";

    public static final String ACCESS_TOKEN_EXPIRE = "access_token_expire";

    public static final String SM4_KEY = "sm4_key";

    public static final String ACTIVATE_URL = "site_url_activate";

    public static final String HOME_URL = "site_url_home";

    public static final String BBS_NAME = "bbs_name";

    public static final String MAIL_CONFIG = "mail_config";

}
