package com.code.help.spider.factory;

import com.code.help.spider.bean.WebClient;

public class WebClientFactory {
    public static WebClient build(){
        return new WebClient();
    }
}
