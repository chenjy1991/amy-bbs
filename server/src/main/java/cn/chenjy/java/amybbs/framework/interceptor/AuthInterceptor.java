package cn.chenjy.java.amybbs.framework.interceptor;

import cn.chenjy.java.amybbs.framework.annotation.Auth;
import cn.chenjy.java.amybbs.framework.annotation.LoginStatus;
import cn.chenjy.java.amybbs.framework.annotation.RoleType;
import cn.chenjy.java.amybbs.mapper.common.UserBaseMapper;
import cn.chenjy.java.amybbs.model.constant.CacheNameConst;
import cn.chenjy.java.amybbs.model.response.CommonResult;
import cn.chenjy.java.amybbs.model.response.auth.AuthResult;
import cn.chenjy.java.amybbs.model.response.auth.LoginInfo;
import cn.chenjy.java.amybbs.service.RedisService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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

    @Autowired
    RedisService redisService;
    @Autowired
    UserBaseMapper userBaseMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        String method = request.getMethod();
        if (handler instanceof HandlerMethod) {
            Auth auth = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
            if (auth != null && auth.loginStatus() == LoginStatus.LOGOUT) {
                LOG.info("无需验证:" + path);
            } else {
                //todo 验证权限
                LOG.info("权限验证:" + path);
                String token = request.getHeader("token");
                if (StringUtils.isEmpty(token)) {
                    backJsonResult(response, AuthResult.UntokenError());
                    return false;
                } else {
                    if (!redisService.hasKey(CacheNameConst.USER_TOKEN_ACCESS + token)) {
                        backJsonResult(response, AuthResult.TokenExpiredError());
                        return false;
                    } else {
                        Integer userId = Integer.parseInt(redisService.get(CacheNameConst.USER_TOKEN_ACCESS + token));
                        LoginInfo loginInfo = null;
                        if (redisService.hasKey(CacheNameConst.USER_INFO + userId)) {
                            loginInfo = JSON.parseObject(redisService.get(CacheNameConst.USER_INFO + userId), LoginInfo.class);
                        } else {
                            loginInfo = new LoginInfo(userBaseMapper.selectByPrimaryKey(userId));
                        }
                        if (loginInfo == null) {
                            //无法查找用户信息
                            backJsonResult(response, AuthResult.UnauthError());
                            return false;
                        }
                        if (auth != null) {
                            if (verifyRoleType(auth.role(), RoleType.valueOf(loginInfo.getRoles()))) {
                                return true;
                            } else {
                                backJsonResult(response, AuthResult.UnauthError());
                                return false;
                            }
                        } else {
                            if (verifyRole(loginInfo.getRoles(), path, method)) {
                                return true;
                            } else {
                                backJsonResult(response, AuthResult.UnauthError());
                                return false;
                            }
                        }

                    }
                }
            }
        }
        backJsonResult(response, CommonResult.ERROR("B0001", "系统执行出错"));
        return false;
    }

    private void backJsonResult(HttpServletResponse response, CommonResult result) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }

    private boolean verifyRoleType(RoleType apiRole, RoleType userRole) {
        if (apiRole == RoleType.OWNER) {
            if (userRole == RoleType.OWNER) {
                return true;
            }
        }
        if (apiRole == RoleType.ADMIN) {
            if (userRole == RoleType.OWNER || userRole == RoleType.ADMIN) {
                return true;
            }
        }
        if (apiRole == RoleType.USER) {
            if (userRole == RoleType.OWNER || userRole == RoleType.ADMIN || userRole == RoleType.USER) {
                return true;
            }
        }
        if (apiRole == RoleType.GUEST) {
            if (userRole == RoleType.OWNER || userRole == RoleType.ADMIN || userRole == RoleType.USER || userRole == RoleType.GUEST) {
                return true;
            }
        }
        return false;
    }

    /**
     * 验证权限
     *
     * @param roles
     * @param path
     * @param method
     * @return 通过返回true，未通过返回false
     */
    private boolean verifyRole(String roles, String path, String method) {
        switch (RoleType.valueOf(roles)) {
            case OWNER:
                return true;
            case ADMIN:
                //验证管理员权限
                break;
            case USER:
                //验证用户权限
                break;
            default:
                return false;
        }
        return false;
    }
}
