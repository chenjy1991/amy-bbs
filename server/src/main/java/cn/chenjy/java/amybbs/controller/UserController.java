package cn.chenjy.java.amybbs.controller;

import cn.chenjy.java.amybbs.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenJY
 * @create 2021/3/6 11:28 下午
 * @DESCRIPTION
 */
@RestController
@RequestMapping("users")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    private static final String TAG = "UserController";

    @Autowired
    AuthService authService;


}
