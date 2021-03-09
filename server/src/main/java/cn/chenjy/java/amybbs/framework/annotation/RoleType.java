package cn.chenjy.java.amybbs.framework.annotation;

public enum RoleType {
    GUEST("GUEST"), USER("USER"), ADMIN("ADMIN"), OWNER("OWNER");
    private String roles;

    RoleType(String roles) {
        this.roles = roles;
    }
}
