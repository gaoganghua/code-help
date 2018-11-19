package com.code.help.code_generate.bean;

import com.code.help.code_generate.enums.GenerateTypeEnum;
import com.code.help.code_generate.enums.KeyTypeEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "generatebean")
@PropertySource(value = "classpath:generate/application-generate.yml")
public class GenerateBean {
    private GenerateTypeEnum generateType;
    private KeyTypeEnum keyType;
    private KeyTypeEnum valueType;
    private String className;
    private Integer num=1;

    public GenerateTypeEnum getGenerateType() {
        return generateType;
    }

    public void setGenerateType(GenerateTypeEnum generateType) {
        this.generateType = generateType;
    }

    public KeyTypeEnum getKeyType() {
        return keyType;
    }

    public void setKeyType(KeyTypeEnum keyType) {
        this.keyType = keyType;
    }

    public KeyTypeEnum getValueType() {
        return valueType;
    }

    public void setValueType(KeyTypeEnum valueType) {
        this.valueType = valueType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
