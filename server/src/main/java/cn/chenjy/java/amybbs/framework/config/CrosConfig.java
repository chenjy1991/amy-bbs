package cn.chenjy.java.amybbs.framework.config;

import cn.chenjy.java.amybbs.model.constant.ResponseHeaderConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * @author ChenJY
 * @create 2021/3/6 11:24 下午
 * @DESCRIPTION
 */
@Configuration
public class CrosConfig {
    private static final Logger LOG = LoggerFactory.getLogger(CrosConfig.class);
    private static final String TAG = "CrosConfig";

    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowCredentials(true);
        config.addExposedHeader(ResponseHeaderConst.AUTH_CAPTCHA);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }
}
