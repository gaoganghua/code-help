package com.code.help.basic;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SelfStarter {
    //@PostConstruct
    public void pre(){
        System.out.println("self starter...");
    }
}
