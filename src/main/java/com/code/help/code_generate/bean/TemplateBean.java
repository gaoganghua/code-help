package com.code.help.code_generate.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "template-bean")
@PropertySource(value = "classpath:generate/application-generate.yml")
public class TemplateBean {
    private String fileName;
    private List<String> assignValue;
    private String targetDir;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getAssignValue() {
        return assignValue;
    }

    public void setAssignValue(List<String> assignValue) {
        this.assignValue = assignValue;
    }

    public String getTargetDir() {
        return targetDir;
    }

    public void setTargetDir(String targetDir) {
        this.targetDir = targetDir;
    }

    @Override
    public String toString() {
        return "TemplateBean{" +
                "fileName='" + fileName + '\'' +
                ", assignValue=" + assignValue +
                ", targetDir='" + targetDir + '\'' +
                '}';
    }
}
