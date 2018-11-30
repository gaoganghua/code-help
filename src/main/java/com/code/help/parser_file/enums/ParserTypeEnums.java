package com.code.help.parser_file.enums;

import org.springframework.util.StringUtils;

public enum ParserTypeEnums {
    EXCEL("excel", "ExcelParser");

    private String type;
    private String value;

    private ParserTypeEnums(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static ParserTypeEnums parse(String type){
        if(StringUtils.isEmpty(type)){
            return EXCEL;
        }
        for(ParserTypeEnums typeEnum:values()){
            if(typeEnum.getType().equals(type)){
                return typeEnum;
            }
        }

        return EXCEL;
    }
}
