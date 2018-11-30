package com.code.help.table_to_bean.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "tablemapping")
@PropertySource(value = "tabletobean/application-datasource.yml")
public class TableMapping {
    private List<BeanDefine> beanDefines;

    private String targetDir;

    private String daoPackage;

    private String beanPackage;

    public List<BeanDefine> getBeanDefines() {
        return beanDefines;
    }

    public void setBeanDefines(List<BeanDefine> beanDefines) {
        this.beanDefines = beanDefines;
    }

    public String getTargetDir() {
        return targetDir;
    }

    public void setTargetDir(String targetDir) {
        this.targetDir = targetDir;
    }

    public String getDaoPackage() {
        return daoPackage;
    }

    public void setDaoPackage(String daoPackage) {
        this.daoPackage = daoPackage;
    }

    public String getBeanPackage() {
        return beanPackage;
    }

    public void setBeanPackage(String beanPackage) {
        this.beanPackage = beanPackage;
    }
}
