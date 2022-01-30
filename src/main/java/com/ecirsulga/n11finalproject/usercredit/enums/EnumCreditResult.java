package com.ecirsulga.n11finalproject.usercredit.enums;

public enum EnumCreditResult {


    ACCEPTED("ACCEPT"),
    DENIED("DENY")
    ;

    private String type;

    EnumCreditResult(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }

}
