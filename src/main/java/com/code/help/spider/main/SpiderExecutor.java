package com.code.help.spider.main;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SpiderExecutor {
    //@PostConstruct
    public void execute(){
        System.out.println("start spider request...");
    }
}
