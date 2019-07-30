package com.code.help.spider_test;

import com.alibaba.fastjson.JSON;
import com.code.help.excel_test.ExcelTest;
import com.code.help.util.JsoupUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
* 豆瓣电影抓取
* */
public class DouBanTest {
    @Test
    public void test() throws Exception {
        Integer num = 37;
        Integer count = 15;
        List<List<Object>> rows = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String url = "https://movie.douban.com/people/154444472/collect?start=" + (i * count) + "&sort=time&rating=all&filter=all&mode=grid";

            String content = getContent(url);
            List<String> hrefs = JsoupUtils.getAttr(content, ".grid-view .item .pic a", "href");

//        for(int i=0;i<1;i++){
            for (String href : hrefs) {
                TimeUnit.MILLISECONDS.sleep(300);
                String page = getContent(href);
                List<Object> row = extract(page);

                System.out.println(href);
                System.out.println(JSON.toJSONString(row));
                rows.add(row);
            }
        }
        ExcelTest.prod(rows, ExcelTest.createHeads(new String[]{"影片", "导演", "国家", "类型", "时间"}));

    }

    public String getContent(String url) throws Exception {
        HttpUriRequest request = new HttpGet(url);
//        request = new HttpGet("https://www.baidu.com/s?ie=UTF-8&wd=%E7%99%BE%E5%BA%A6");
        request.addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36");
        request.addHeader("Referer", "https://www.douban.com/people/154444472/");
        request.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        request.addHeader("Accept-Encoding", "gzip, deflate");
        request.addHeader("Cookie", "ll=\"108288\"; bid=Fq-2BsLHrHU; __utma=30149280.976039817.1564455052.1564455052.1564455052.1; __utmc=30149280; __utmz=30149280.1564455052.1.1.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; ap_v=0,6.0; douban-profile-remind=1; dbcl2=\"154444472:Eww+nHCXRPA\"; ck=Ojku; __utmv=30149280.15444; push_noty_num=0; __utmb=30149280.15.10.1564455052; _pk_ref.100001.4cf6=%5B%22%22%2C%22%22%2C1564455471%2C%22https%3A%2F%2Fwww.douban.com%2Fpeople%2F154444472%2F%22%5D; _pk_ses.100001.4cf6=*; __utma=223695111.1074461691.1564455471.1564455471.1564455471.1; __utmb=223695111.0.10.1564455471; __utmc=223695111; __utmz=223695111.1564455471.1.1.utmcsr=douban.com|utmccn=(referral)|utmcmd=referral|utmcct=/people/154444472/; _pk_id.100001.4cf6=ccfa547d86831925.1564455471.1.1564456615.1564455471.; push_doumail_num=0");

        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        ((CloseableHttpClient) client).close();

        return content;
    }

    public List<Object> extract(String page) {
        String name = JsoupUtils.getText(page, "span[property=v:itemreviewed]");
        String au = JsoupUtils.getText(page, "div#info span.pl:contains(导演) + span");
        String coun = JsoupUtils.siblingHtml(page, "div#info span.pl:contains(制片国家)");
        String sty = JsoupUtils.getText(page, "div#info span.pl:contains(类型) ~ span[property=v:genre]", "/");
        String tim = JsoupUtils.getText(page, "span.year");

        List<Object> row = new ArrayList<>();
        row.add(name);
        ;
        row.add(au);
        row.add(coun);
        row.add(sty);
        row.add(tim.substring(1, tim.lastIndexOf(")")));

        return row;
    }

}
