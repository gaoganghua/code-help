package com.code.help.spider.enums;

import org.springframework.util.StringUtils;

public enum WebMethodEnum {
    PUT("put"), DELETE("delete"), POST("post"), GET("get"), HEAD("head"), OPTIONS("options");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    WebMethodEnum(String value) {
        this.value = value;
    }

    public static WebMethodEnum parse(String method) {
        if (StringUtils.isEmpty(method)) {
            return GET;
        }
        for (WebMethodEnum webMethod : values()) {
            if (webMethod.getValue().equals(method)) {
                return webMethod;
            }
        }
        return GET;

    }
}
