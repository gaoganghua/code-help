package com.code.help.spider.util;

import okhttp3.*;

import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class ClientUtils {
    private static final String proxyUrl = "http://www.xicidaili.com/nn/";

    public static String getProxyAddress() throws IOException, XPathExpressionException {
        OkHttpClient client = new OkHttpClient();
        Request.Builder builder = new Request.Builder().url(proxyUrl);
        builder.get();
        builder.addHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        builder.addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        Request request = builder.build();

        Response resp  = client.newCall(request).execute();
        String body = resp.body().string();
        System.out.println(ParseUtils.getXpath()==null);
        System.out.println(ParseUtils.parseNodeByJsoup(body, "table#ip_list > tr:gt(1) > td:eq(1)/text()").size());
        for(String s: ParseUtils.parseNodeByJsoup(body, "table#ip_list > tr:gt(1) > td:eq(1)/text()")){
//            System.out.println(s);
        }
        return body;
    }


}
