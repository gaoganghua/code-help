package com.code.help;

import com.code.help.spider.util.IOUtils;
import com.code.help.util.FileUtils;
import com.code.help.util.JsoupUtils;
import org.jsoup.Jsoup;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class PageExtractTest {
    @Test
    public void testt() throws IOException {
        String ss = IOUtils.parseStream(new FileInputStream(FileUtils.getFileInResource("test/page.html")), Charset.defaultCharset().name());
//        System.out.println(s);

//        List<String> strs = JsoupUtils.getAttr(ss, ".grid-view .item .pic a", "href");
////        List<String> aas = JsoupUtils.getTexts(ss, ".grid-view .info li tags");
//        for(String s:strs){
//            System.out.println();
//        }
        //
        String name = JsoupUtils.getText(ss, "span[property=v:itemreviewed]");
        String au = JsoupUtils.getText(ss, "div#info span.pl:contains(导演) + span");
        String coun = JsoupUtils.siblingHtml(ss, "div#info span.pl:contains(制片国家)");
        String sty = JsoupUtils.getText(ss, "div#info span.pl:contains(类型) ~ span[property=v:genre]", "/");
        String tim = JsoupUtils.getText(ss, "span.year");
        System.out.println(name+":"+au+":"+sty+":"+coun+":"+tim);


    }

}
