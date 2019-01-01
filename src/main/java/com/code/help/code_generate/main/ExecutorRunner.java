package com.code.help.code_generate.main;

import com.code.help.code_generate.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class ExecutorRunner {
    @Autowired
    private AssignValueToTemplate assignValueToTemplate;

    //@PostConstruct
    public void testper() throws Exception {
        assignValueToTemplate.assignValue();
    }
}
