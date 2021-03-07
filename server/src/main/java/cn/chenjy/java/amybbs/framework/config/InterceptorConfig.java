package cn.chenjy.java.amybbs.framework.config;

import cn.chenjy.java.amybbs.framework.interceptor.AuthInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ChenJY
 * @create 2021/3/7 10:27 下午
 * @DESCRIPTION
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private static final Logger LOG = LoggerFactory.getLogger(InterceptorConfig.class);
    private static final String TAG = "InterceptorConfig";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**").order(0);
    }
}
