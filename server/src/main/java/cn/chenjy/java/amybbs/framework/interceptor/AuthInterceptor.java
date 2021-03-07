package cn.chenjy.java.amybbs.framework.interceptor;

import cn.chenjy.java.amybbs.framework.annotation.Auth;
import cn.chenjy.java.amybbs.framework.annotation.LoginStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChenJY
 * @create 2021/3/7 10:18 下午
 * @DESCRIPTION
 */
public class AuthInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(AuthInterceptor.class);
    private static final String TAG = "AuthInterceptor";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            Auth auth = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
            if (auth == null) {
                System.out.println("验证token");
            } else {
                LoginStatus loginStatus = auth.loginStatus();
                if (loginStatus == LoginStatus.LOGOUT) {
                    System.out.println("无需验证");
                } else {
                    System.out.println("验证token");
                }
            }
        }
        return true;
    }
}
