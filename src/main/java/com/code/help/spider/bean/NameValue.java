package com.code.help.spider.bean;

import java.io.Serializable;

public class NameValue implements Serializable {
    private String name;
    private Object value;

    public NameValue() {
        this((String) null, (String) null);
    }

    public NameValue(String name, Object value) {
        this.name = null;
        this.value = null;
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NameValue{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
