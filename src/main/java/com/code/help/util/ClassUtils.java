package com.code.help.util;

public class ClassUtils {
    public static Object getObject(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object obj = null;
        Class cls = Class.forName(className);
        return cls.newInstance();
    }
}
