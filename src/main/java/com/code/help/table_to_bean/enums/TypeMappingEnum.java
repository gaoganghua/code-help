package com.code.help.table_to_bean.enums;

import org.springframework.util.StringUtils;

public enum TypeMappingEnum {
    UNKOWN("", ""), INT("INT", "Integer"), INT2("INTEGER", "Integer"), VARCHAR("VARCHAR", "String"), CHAR("CHAR", "String"), TEXT("TEXT", "String"),
    DECIMAL("DECIMAL", "BigDecimal"), BIT("BIT", "Boolean"), TINYINT("TINYINT", "Byte"), BIGINT("BIGINT", "Long"),
    TIMESTAMP("TIMESTAMP", "Date"), DATETIME("DATETIME", "Date"), DATE("DATE", "Date"), TIME("TIME", "Date");

    private String tabValue;

    private String javaValue;

    public String getJavaValue() {
        return javaValue;
    }

    public void setJavaValue(String javaValue) {
        this.javaValue = javaValue;
    }

    public String getTabValue() {
        return tabValue;
    }

    public void setTabValue(String tabValue) {
        this.tabValue = tabValue;
    }

    private TypeMappingEnum(String tabValue, String javaValue) {
        this.tabValue = tabValue;
        this.javaValue = javaValue;
    }

    public static TypeMappingEnum getJavaType(String tabValue) {
        if (StringUtils.isEmpty(tabValue)) {
            return UNKOWN;
        }

        for (TypeMappingEnum typeMapping : values()) {
            if (typeMapping.getTabValue().equals(tabValue)) {
                return typeMapping;
            }
        }
        return UNKOWN;
    }
}
