package cn.chenjy.java.amybbs.service;

public interface MailService {

    void sendRegisterMail(String email, String code);

    void sendFindbackPwdMail(String email, String code);

}
