package cn.chenjy.java.amybbs.service;

public interface MailService {

    void sendRegisterMail(String email);

    void sendFindbackPwdMail(String email, String code);

}
