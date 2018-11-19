package com.code.help.code_generate.enums;

public enum KeyTypeEnum {
    STRING("string", "java.lang.String"), INTEGER("int", "java.lang.Integer"), BOOLEAN("boolean", "java.lang.Boolean"), LONG("long", "java.long.Long");

    private String mappingName;
    private String fullName;

    public String getMappingName() {
        return mappingName;
    }

    public void setMappingName(String mappingName) {
        this.mappingName = mappingName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private KeyTypeEnum(String mappingName, String fullName) {
        this.mappingName = mappingName;
        this.fullName = fullName;
    }

    public static KeyTypeEnum parse(String mappingName){
        if(mappingName==null){
            return STRING;
        }
        for(KeyTypeEnum item:values()){
            if(item.getMappingName().equals(mappingName)){
                return item;
            }
        }
        return STRING;
    }
}
