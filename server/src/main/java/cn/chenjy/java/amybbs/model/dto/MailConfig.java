package cn.chenjy.java.amybbs.model.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author ChenJY
 * @create 2021/3/8 10:48 下午
 * @DESCRIPTION
 */
public class MailConfig {

    /**
     * host : smtp.exmail.qq.com
     * port : 465
     * from : amy-bbs-no-reply@chenjy.cn
     * user : amy-bbs-no-reply@chenjy.cn
     * pass : nfa5mGeGV6BtN4iE
     * starttlsEnable : true
     * sslEnable : true
     * socketFactoryClass : javax.net.ssl.SSLSocketFactory
     * socketFactoryFallback : true
     * socketFactoryPort : 465
     * timeout : 0
     * connectionTimeout : 0
     */

    @JSONField(name = "host")
    private String host;
    @JSONField(name = "port")
    private Integer port;
    @JSONField(name = "from")
    private String from;
    @JSONField(name = "user")
    private String user;
    @JSONField(name = "pass")
    private String pass;
    @JSONField(name = "starttlsEnable")
    private Boolean starttlsEnable;
    @JSONField(name = "sslEnable")
    private Boolean sslEnable;
    @JSONField(name = "socketFactoryClass")
    private String socketFactoryClass;
    @JSONField(name = "socketFactoryFallback")
    private Boolean socketFactoryFallback;
    @JSONField(name = "socketFactoryPort")
    private Integer socketFactoryPort;
    @JSONField(name = "timeout")
    private Long timeout;
    @JSONField(name = "connectionTimeout")
    private Long connectionTimeout;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getStarttlsEnable() {
        return starttlsEnable;
    }

    public void setStarttlsEnable(Boolean starttlsEnable) {
        this.starttlsEnable = starttlsEnable;
    }

    public Boolean getSslEnable() {
        return sslEnable;
    }

    public void setSslEnable(Boolean sslEnable) {
        this.sslEnable = sslEnable;
    }

    public String getSocketFactoryClass() {
        return socketFactoryClass;
    }

    public void setSocketFactoryClass(String socketFactoryClass) {
        this.socketFactoryClass = socketFactoryClass;
    }

    public Boolean getSocketFactoryFallback() {
        return socketFactoryFallback;
    }

    public void setSocketFactoryFallback(Boolean socketFactoryFallback) {
        this.socketFactoryFallback = socketFactoryFallback;
    }

    public Integer getSocketFactoryPort() {
        return socketFactoryPort;
    }

    public void setSocketFactoryPort(Integer socketFactoryPort) {
        this.socketFactoryPort = socketFactoryPort;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public Long getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(Long connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }
}
