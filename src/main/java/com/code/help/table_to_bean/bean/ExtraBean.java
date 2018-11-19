package com.code.help.table_to_bean.bean;

import com.code.help.table_to_bean.enums.BeanEnum;

public class ExtraBean {
    private String beanName;

    private BeanEnum beanEnums = BeanEnum.NORMAL;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public BeanEnum getBeanEnums() {
        return beanEnums;
    }

    public void setBeanEnums(BeanEnum beanEnums) {
        this.beanEnums = beanEnums;
    }
}
