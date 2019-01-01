package com.code.help.spider.util;

import com.code.help.util.FileUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.xml.xpath.XPathExpressionException;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class ClientUtils {
    private static final String proxyUrl = "http://www.xicidaili.com/nn/";
    private static final String proxyUrl2 = "https://proxy.mimvp.com/free.php";

    private static final String proxyUrlDirName = "/Users/chancelee/Desktop/DEFAULT/spider";
    private static final String proxyUrlFileName = "proxy_url.txt";
    private static final String formatPattern = "yyyy-MM-dd";

    private static final Logger logger = LoggerFactory.getLogger(ClientUtils.class);

    public static String getProxyAddress() throws IOException, XPathExpressionException, InterruptedException {
        String proxyUrl = getProxyUrlFromFile();

        while (StringUtils.isEmpty(proxyUrl)) {
            System.out.println("newly request proxy url....");
            String body = getResponseBody();
            writeProxyToFile(body);
            proxyUrl = getProxyUrlFromFile();
        }

        while (!checkProxyUrl(proxyUrl)) {
            proxyUrl = getProxyAddress();
        }

        return proxyUrl;
    }

    private static Boolean checkProxyUrl(String proxyUrl) {
        HttpClient client = new HttpClient();
        String[] proxys = proxyUrl.split(":");
        client.getHostConfiguration().setProxy(proxys[0], Integer.parseInt(proxys[1]));
//        client.getParams().setParameter(HttpClientParams.HEAD_BODY_CHECK_TIMEOUT, );

        GetMethod method = new GetMethod("https://www.baidu.com/index.php");
        method.addRequestHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        method.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        method.addRequestHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        method.addRequestHeader("Accept-Encoding", "gzip, deflate, br");
        method.addRequestHeader("Connection", "keep-alive");
        try {
            client.executeMethod(method);
            if (method.getStatusCode() == 200) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private static String getProxyUrlFromFile() throws IOException, InterruptedException {
        File proxyFile = FileUtils.getFileByName(proxyUrlDirName + "/" + proxyUrlFileName);
        if (!proxyFile.exists()) {
            return null;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(proxyFile)));
        String firstLine = br.readLine();
        if (!DateUtil.formatDate(new Date(), formatPattern).equals(firstLine)) {
            return null;
        }
        int radomNum = RandomUtils.getRandom(Integer.parseInt(br.readLine())) + 1;

        for (int i = 1; i < radomNum; i++) {
            br.readLine();
        }
        String proxyUrl = br.readLine();
        br.close();
        logger.info("get new proxy address:{} line, proxy url:{}", radomNum, proxyUrl);
        return proxyUrl;
    }

    private static String getResponseBody() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request.Builder builder = new Request.Builder().url(proxyUrl);
        builder.get();
        builder.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        builder.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        Request request = builder.build();

        Response resp = client.newCall(request).execute();
        return resp.body().string();
    }

    private static void writeProxyToFile(String body) throws XPathExpressionException, IOException {
        List<String> proxyHosts = ParseUtils.parseNodeByJsoup(body, "table#ip_list tr:contains(HTTPS) td:gt(0):lt(6)/text()");

        File proxyUrlFile = FileUtils.getFileByDirAndName(proxyUrlDirName, proxyUrlFileName);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(DateUtil.formatDate(new Date(), formatPattern + "\n"));
        stringBuffer.append(proxyHosts.size() / 5 + "\n");
        //只得到https代理地址
        for (int i = 0; i < proxyHosts.size(); i = i + 5) {
            String line = proxyHosts.get(i) + ":" + proxyHosts.get(i + 1);
            stringBuffer.append(line + "\n");
        }
        FileUtils.writeFileByString(proxyUrlFile, stringBuffer.toString());
    }

//    private String


}
