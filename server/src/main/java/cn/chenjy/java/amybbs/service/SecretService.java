package cn.chenjy.java.amybbs.service;

public interface SecretService {

    String encodeBySm4(String key);

    String decodeBySm4(String key);
}
