package com.code.help.web_driver;

import com.code.help.spider.bean.WebClient;
import com.code.help.spider.bean.WebRequest;
import com.code.help.spider.bean.WebResponse;
import com.code.help.spider.factory.WebFactory;
import com.code.help.spider.util.ClientUtils;
import com.code.help.spider.util.ParseUtils;
import com.code.help.util.FileUtils;
import com.code.help.util.PatternUtils;
import com.code.help.util.YamlUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import javax.xml.xpath.XPathExpressionException;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestWebClient {
    @Test
    public void test() throws Exception {
        testClient();
//        testYaml();
//        System.out.println(ClientUtils.getProxyAddress());
//        testOk();
    }

    private void testOk() throws IOException {
        String url = "https://sq.58.com/ershoufang/36351265069989x.shtml?iuType=p_1&PGTID=0d300000-0040-50c3-e5b9-f3a0092ab0cd&ClickID=1";
//        url = "https";
//        System.out.println(PatternUtils.groupOne(url, "://([^/]+)/", 1));
//        System.out.println(PatternUtils.match(url, "http"));
//        System.out.println(Pattern.matches("http", url));
//        Pattern p  = Pattern.compile("(\\d)-([a-z])-(\\d{0,3})");
//        url = "3-m-44;3-yy-11;9-c-2";
////        Matcher m = p.matcher(url);
//        System.out.println(m.groupCount());

//        while(m.find()){
//            System.out.println(m.group());
////            System.out.println(m.group(1));
////            System.out.println(m.group(2));
////            System.out.println(m.group(3));
//        }
//        for(Map.Entry<Integer, List<String>> en:PatternUtils.groupAll(url, "(\\d)-([a-z])-(\\d{0,3})").entrySet()){
//            System.out.println(en.getKey());
//            for(String s:en.getValue()){
//                System.out.println(s);
//            }
//        }


//        System.out.println(Pattern.matches("https", url));
        OkHttpClient client = new OkHttpClient();
        String re = "https://sq.58.com/ershoufang/36351265069989x.shtml?iuType=p_1&PGTID=0d300000-0040-50c3-e5b9-f3a0092ab0cd&ClickID=1";
        String co = "BAIDUID=F84824E997CC27748B441FEC160A917B:FG=1; BIDUPSID=F84824E997CC27748B441FEC160A917B; PSTM=1544345702; MCITY=-%3A; CPROID=F84824E997CC27748B441FEC160A917B:FG=1; H_PS_PSSID=1465_21094_28131_27751_27244_27508; BDORZ=FFFB88E999055A3F8A630C64834BD6D0; delPer=0; PSINO=1; BDRCVFR[Fc9oatPmwxn]=srT4swvGNE6uzdhUL68mv3; locale=zh; ISBID=F84824E997CC27748B441FEC160A917B:FG=1; ISUS=F84824E997CC27748B441FEC160A917B:FG=1; pgv_pvi=5243636736; pgv_si=s5168842752; BCLID=8153196861976495522; BDSFRCVID=C58OJeC627uu_uJ9QGGAhyWafebYuH7TH6ao8PTw_Yv4AShMbmJZEG0Pef8g0KubfybnogKKKgOTHICF_2uxOjjg8UtVJeC6EG0P3J; H_BDCLCKID_SF=tJ4eoI-XJKt3fP36q6_Wq4tehHRmt6v9WDTm_D_5b45rfqFw0fJnLtk-3UQhK4jkbm-f-pPKKRAWVMb6Bpr-jM_9M-ca2xTz3mkjbn5Dfn02OP5PbRrDh44syPRiKMRnWg5mKfA-b4ncjRcTehoM3xI8LNj405OTt2LE3-oJqC8-MDIl3f";
        Request req = new Request.Builder().url(url).addHeader("Referer", re).addHeader("Cookie", co).build();

        Response resp = client.newCall(req).execute();
       System.out.println(resp.body().string());
    }
    public void testClient() throws IOException, XPathExpressionException {
        String url = "https://sq.58.com/ershoufang/36351265069989x.shtml?iuType=p_1&PGTID=0d300000-0040-50c3-e5b9-f3a0092ab0cd&ClickID=1";
//        url = "http://www.xicidaili.com/nn/";
        url="https://www.baidu.com";
        WebClient client = WebFactory.buildClient().init();
//        WebRequest request = new WebRequest("https://www.baidu.com/index.php");
        WebRequest request = new WebRequest(url);
        request.setCookie("BAIDUID=F84824E997CC27748B441FEC160A917B:FG=1; BIDUPSID=F84824E997CC27748B441FEC160A917B; PSTM=1544345702; MCITY=-%3A; CPROID=F84824E997CC27748B441FEC160A917B:FG=1; H_PS_PSSID=1465_21094_28131_27751_27244_27508; BDORZ=FFFB88E999055A3F8A630C64834BD6D0; delPer=0; PSINO=1; BDRCVFR[Fc9oatPmwxn]=srT4swvGNE6uzdhUL68mv3; locale=zh; ISBID=F84824E997CC27748B441FEC160A917B:FG=1; ISUS=F84824E997CC27748B441FEC160A917B:FG=1; pgv_pvi=5243636736; pgv_si=s5168842752; BCLID=8153196861976495522; BDSFRCVID=C58OJeC627uu_uJ9QGGAhyWafebYuH7TH6ao8PTw_Yv4AShMbmJZEG0Pef8g0KubfybnogKKKgOTHICF_2uxOjjg8UtVJeC6EG0P3J; H_BDCLCKID_SF=tJ4eoI-XJKt3fP36q6_Wq4tehHRmt6v9WDTm_D_5b45rfqFw0fJnLtk-3UQhK4jkbm-f-pPKKRAWVMb6Bpr-jM_9M-ca2xTz3mkjbn5Dfn02OP5PbRrDh44syPRiKMRnWg5mKfA-b4ncjRcTehoM3xI8LNj405OTt2LE3-oJqC8-MDIl3f");
        request.addHeader("Referer", "https://sq.58.com/ershoufang/36351265069989x.shtml?iuType=p_1&PGTID=0d300000-0040-50c3-e5b9-f3a0092ab0cd&ClickID=1");

        WebResponse response = client.execute(request);
        System.out.println(response.getBody());
//        System.out.println(response.getBody());

//        List<String> texts = ParseUtils.parseNodeByJsoup(response.getBody(), "table#ip_list tr td:gt(0):lt(3)/text()");
////        List<String> texts = ParseUtils.parseNodeByJsoup(response.getBody(), "table#ip_list tr td:gt(0):lt(3)/tex");
////        List<String> texts = ParseUtils.parseNodeByJsoup(response.getBody(), "table#ip_list tr td:eq(0) img/[:src,alt]");
//        for (String s : texts) {
//            System.out.println(s);
//        }
//
//        System.out.println(texts.size());
//        Elements elements = Jsoup.parse(response.getBody()).select("table#ip_list tr");
////        Jsoup.parse(response.getBody()).
    }

    public void testYaml() throws IOException {
        Object ob = YamlUtils.parse("spider/proxy_url.yml", "proxy_url");
        System.out.println(ob.getClass());
        List<String> urls = (List<String>) ob;
        for (String s : urls) {
            System.out.println(s);
        }

//        Map<String, String> maps = new HashMap<>();
//        maps.put("aa", "aa");
//        Yaml yaml = new Yaml();
//        String result = yaml.dumpAsMap(maps);
//        System.out.println(result);
//        File newFile = FileUtils.getFileInResource("spider/proxy_url.yml");
//        yaml.dump(maps, new FileWriter(newFile));
//        System.out.println();
//        PrintWriter writer = new PrintWriter(newFile);
//        writer.print(result);
//        writer.flush();
//        writer.close();
    }
}
