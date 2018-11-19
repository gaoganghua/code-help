package com.code.help.table_to_bean.bean;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeanDefine {
    /**
     *
     */
    private String tabName;

    private String beanName;

    private Boolean generateMapper;

    private Boolean insert = true;

    private Boolean insertRecords = true;

    private Boolean update = true;

    private Boolean query = true;

    private Boolean generateDao = true;

    private List<ExtraBean> extraBeans;

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Boolean getGenerateMapper() {
        return generateMapper;
    }

    public void setGenerateMapper(Boolean generateMapper) {
        this.generateMapper = generateMapper;
    }

    public Boolean getInsert() {
        return insert;
    }

    public void setInsert(Boolean insert) {
        this.insert = insert;
    }

    public Boolean getInsertRecords() {
        return insertRecords;
    }

    public void setInsertRecords(Boolean insertRecords) {
        this.insertRecords = insertRecords;
    }

    public Boolean getUpdate() {
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }

    public Boolean getQuery() {
        return query;
    }

    public void setQuery(Boolean query) {
        this.query = query;
    }

    public Boolean getGenerateDao() {
        return generateDao;
    }

    public void setGenerateDao(Boolean generateDao) {
        this.generateDao = generateDao;
    }

    public List<ExtraBean> getExtraBeans() {
        return extraBeans;
    }

    public void setExtraBeans(List<ExtraBean> extraBeans) {
        this.extraBeans = extraBeans;
    }
}
