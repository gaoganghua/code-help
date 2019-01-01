package com.code.help.spider.factory;

import com.code.help.spider.bean.WebClient;

public class WebFactory {
    public static WebClient buildClient(){
        return new WebClient();
    }
}
