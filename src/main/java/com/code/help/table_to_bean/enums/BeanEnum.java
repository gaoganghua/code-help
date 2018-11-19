package com.code.help.table_to_bean.enums;

import org.springframework.util.StringUtils;

public enum BeanEnum {
    ALL("all"), NORMAL("normal");

    private String value;

    private BeanEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static BeanEnum parse(String value) {
        if (StringUtils.isEmpty(value)) {
            return BeanEnum.NORMAL;
        }
        for (BeanEnum beanEnums : values()) {
            if (beanEnums.getValue().equals(value)) {
                return beanEnums;
            }
        }
        return BeanEnum.NORMAL;
    }
}
