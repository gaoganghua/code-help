package com.code.help.spider.enums;

import org.springframework.util.StringUtils;

public enum ParamTypeEnum {
    STRING("string"), FILE("file"), BYTEARRAY("bytearray"), INPUTSTREAM("inputstream"), MULTIPART("multipart");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    ParamTypeEnum(String value) {
        this.value = value;
    }

    public static ParamTypeEnum parse(String type) {
        if (StringUtils.isEmpty(type)) {
            return STRING;
        }
        for (ParamTypeEnum paramType : values()) {
            if (paramType.getValue().equals(type)) {
                return paramType;
            }
        }
        return STRING;
    }
}
