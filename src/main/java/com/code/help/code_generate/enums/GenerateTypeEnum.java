package com.code.help.code_generate.enums;

import java.util.List;

public enum GenerateTypeEnum {
    LIST("list", "java.util.ArrayList"), SET("set", "java.util.HashSet"), MAP("map", "java.util.HashMap"), ARRAY("array", "-1");

    private String mappingName;
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMappingName() {
        return mappingName;
    }

    public void setMappingName(String mappingName) {
        this.mappingName = mappingName;
    }

    private GenerateTypeEnum(String mappingName, String fullName) {
        this.mappingName = mappingName;
        this.fullName = fullName;
    }

    public static GenerateTypeEnum parse(String mappingName){
        if(mappingName==null){
            return LIST;
        }
        for(GenerateTypeEnum item:values()){
            if(item.getMappingName().equals(mappingName)){
                return item;
            }
        }
        return LIST;
    }
}
