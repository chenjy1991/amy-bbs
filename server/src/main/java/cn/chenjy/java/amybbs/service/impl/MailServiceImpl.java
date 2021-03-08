package cn.chenjy.java.amybbs.service.impl;

import cn.chenjy.java.amybbs.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author ChenJY
 * @create 2021/3/8 10:42 上午
 * @DESCRIPTION
 */
@Service
public class MailServiceImpl implements MailService {
    private static final Logger LOG = LoggerFactory.getLogger(MailServiceImpl.class);
    private static final String TAG = "MailServiceImpl";

    @Override
    public void sendRegisterMail(String email) {

    }

    @Override
    public void sendFindbackPwdMail(String email, String code) {

    }
}
