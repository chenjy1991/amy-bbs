package cn.chenjy.java.amybbs.framework.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
    @AliasFor("loginStatus")
    LoginStatus value() default LoginStatus.LOGIN;

    @AliasFor("value")
    LoginStatus loginStatus() default LoginStatus.LOGIN;

    RoleType role() default RoleType.USER;
}
