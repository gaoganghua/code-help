package com.code.help.test_code_generate;

import com.code.help.BaseApplicationTests;
import com.code.help.code_generate.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@Component
public class Test extends BaseApplicationTests {
    @Autowired
    private Person person;
//
    @Value("${aa}")
    private String appName;

    @org.junit.Test
    public void test(){
        System.out.println(person.getName());
        System.out.println(appName);
//        String
    }
}
