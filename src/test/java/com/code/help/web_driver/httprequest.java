package com.code.help.web_driver;

import com.code.help.spider.bean.WebClient;
import com.code.help.spider.bean.WebRequest;
import com.code.help.spider.bean.WebResponse;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.client.params.CookiePolicy;
import org.junit.Test;

import java.io.*;
import java.util.zip.GZIPInputStream;

public class httprequest {
    @Test
    public void test() throws Exception {
        WebRequest request = new WebRequest();
        request.setUrl("https://www.baidu.com");

        WebClient client = new WebClient();
        WebResponse response = client.execute(request);
        System.out.println(response.getBody());
//        System.out.println(ClientUtils.getProxyAddress());
//        testokhttp("https://www.baidu.com/");
//        testpost();
        org.apache.http.client.HttpClient client1 = null;
    }

    public void testokhttp(String url) throws IOException {
//        OkHttpClient client = new OkHttpClient();
//        Request req = new Request.Builder().url(url).build();
//        Response resp = client.newCall(req).execute();
//        byte[] bytes = resp.body().bytes();
    }

    @Test
    public void testpost22() throws IOException {
        WebClient client = new WebClient();
//        client.
    }
    @Test
    public void testpost() throws IOException {
//    HttpClientParams params2 = new HttpClientParams();
////    params2.setHttpElementCharset("UTF-8");
//    params2.setCookiePolicy(org.apache.commons.httpclient.cookie.CookiePolicy.BROWSER_COMPATIBILITY);
//    params2.setContentCharset("UTF-8");
//    params2.setParameter("http.protocol.content-charset", "UTF-8");

        HttpClient httpClient = new HttpClient();
//    HttpConnectionManagerParams p3 = new HttpConnectionManagerParams();
//    p3.setDefaults(params2);
//        httpClient.getHttpConnectionManager().setParams(p3);
//    HostParams params = new HostParams();
//params.setDefaults(params2);
//httpClient.getHostConfiguration().setParams(params);


//    HttpClientParams params2 = new HttpClientParams();
//    params2.setHttpElementCharset("UTF-8");
//    params2.setCookiePolicy(org.apache.commons.httpclient.cookie.CookiePolicy.BROWSER_COMPATIBILITY);
//    params2.setContentCharset("UTF-8");
//    httpClient.setParams(params2);
//    httpClient.
//
//    httpClient.getHttpConnectionManager().get
        HostConfiguration host = new HostConfiguration();
        host.setHost("localhost");
//    host.setProxy("61.135.155.82", 443);
//    host.set
        httpClient.setHostConfiguration(host);
//        httpClient.getHostConfiguration().setParams(params);
//        httpClient.getHostConfiguration().setProxy("localhost", 8888);
        httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY); // 设置 HttpClient 接收 Cookie,用与浏览器一样的策
//        httpClient.set

        NameValuePair[] data = {new NameValuePair("key", "value")};
//        PostMethod method = new PostMethod("https://www.baidu.com/");
//    GetMethod method = new GetMethod("https://proxy.mimvp.com/free.php");
//        GetMethod method = new GetMethod("https://proxy.mimvp.com/free.php");
    GetMethod method = new GetMethod("https://www.baidu.com/");
        HttpMethodParams params1 = new HttpMethodParams();
//    params1.setHttpElementCharset("UTF-8");
//        params1.setCookiePolicy(org.apache.commons.httpclient.cookie.CookiePolicy.BROWSER_COMPATIBILITY);
//    params1.setContentCharset("UTF-8");
//    params1.setre
//        method.setParams(params1);


//httpClient.setParams(params2);
//    method.getParams().set

//        method.addParameters(data);
//        method.setRequestBody(data);
        // 获取客户端的cookie
//        Cookie[] cookies = httpClient.getState().getCookies();
//        StringBuffer tmpcookies = new StringBuffer();
//        for (Cookie c : cookies) {
//            tmpcookies.append(c.toString() + ";");
//        }
        //携带请求的cookie
//        method.setRequestHeader("cookie", tmpcookies.toString());
        method.addRequestHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        method.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        method.addRequestHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        method.addRequestHeader("Accept-Encoding", "gzip, deflate, br");
        method.addRequestHeader("Connection", "keep-alive");
//        method.addRequestHeader("Cookie","BAIDUID=91D8E49892DF8B3D5CA3E11595454960:FG=1; BIDUPSID=91D8E49892DF8B3D5CA3E11595454960; PSTM=1543849168; BD_UPN=133252; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; H_PS_PSSID=1438_21100_27508; H_PS_645EC=f71fsdrEZ2zoZiw%2BPVUuLumJSYkRfXmLWgggwdcieULoND5cyi94MEdoDO0; delPer=0; BD_CK_SAM=1; PSINO=5; BDRCVFR[Fc9oatPmwxn]=mk3SLVN4HKm; locale=zh; BD_HOME=0");
        method.addRequestHeader("Pragma", "no-cache");
        method.addRequestHeader("Cache-Control", "no-cache");
        method.addRequestHeader("Upgrade-Insecure-Requests", "1");
        method.addRequestHeader("Referer", "https://proxy.mimvp.com/freeopen.php?proxy=in_hp&sort=&page=2");
//        method.addRequestHeader("Cookie", "PHPSESSID=osarsetone4ouvn0j15mcpm1h5; Hm_lvt_51e3cc975b346e7705d8c255164036b3=1543892728; Hm_lpvt_51e3cc975b346e7705d8c255164036b3=1543896677");
        method.addRequestHeader("Content-Type", "text/html; charset=utf-8");
        //method.addResponseFooter(new Header("Content-Type","text/html; charset=utf-8"));
//        method.addRequestHeader(new Header("Content-Type", "application-json"));
//        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");//解决中文乱码

        //发起请求
        int executeMethod = httpClient.executeMethod(method);
        System.out.println(method.getResponseCharSet());
        System.out.println(method.getStatusLine().getStatusCode());
//        //获取请求头
//        Header[] headers = method.getResponseHeaders();
//        //获取响应,postMethod 提供两种方式,getResponseBodyAsString和getResponseBodyAsStream,但前者在没指定Content-length或者Content-length过长时会报错,推荐使用后者.
        InputStream stream = method.getResponseBodyAsStream();
//    BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "utf-8"));
//    StringBuffer buffer = new StringBuffer();
//    String result = null;
//    while( (result = reader.readLine()) != null )
//        buffer.append(result);
//
//
//    byte[] buffer = new byte[HttpBase.BUFFER_SIZE];
//    int bufferFilled = 0;
//    int totalRead = 0;
//    ByteArrayOutputStream out = new ByteArrayOutputStream();
//    while ((bufferFilled = in.read(buffer, 0, buffer.length)) != -1 && totalRead + bufferFilled <= contentLength) {
//        totalRead += bufferFilled;
//        out.write(buffer, 0, bufferFilled);
//    }
//
//    // use read length if response header doesn't content length
//    if (contentLengthString == null) {
//        headers.set(Response.CONTENT_LENGTH, String.valueOf(totalRead));
//    }
//    content = out.toByteArray();

        System.out.println(method.getResponseBodyAsString());

        BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "ISO-8859-1"));
        String tmp = null;
        String htmlRet = "";
        while ((tmp = reader.readLine()) != null) {
            htmlRet += tmp + "\r\n";
        }

//System.out.println(htmlRet);
        System.out.println(new String(htmlRet.getBytes("UTF-8"), "ISO-8859-1"));

//    result = buffer.toString();
//    System.out.println(result);

//
        java.lang.String responseContent = method.getResponseBodyAsString();
        System.out.println(responseContent);
//        System.out.println(new java.lang.String(responseContent.getBytes("ISO-8859-1"), "UTF-8"));
//    System.out.println(new java.lang.String(responseContent.getBytes("UTF-8"), "US-ASCII"));


//    ByteArrayOutputStream bos = new ByteArrayOutputStream();
//    BufferedInputStream bis = new BufferedInputStream(stream);
//    int len = 0;
//    while((len = bis.read())!=-1){
//        bos.write();
//    }
//        System.out.println(new String());


//        int stateCode = method.getStatusCode();
//
//        stateCode = method.getStatusLine().getStatusCode();
//        String stateLine = method.getStatusLine().toString();
//        HttpVersion httpVersion = HttpVersion.HTTP_1_1;
//        HostConfiguration host = null;
////        org.apache.http.client.HttpClient cc = null;
////        HttpRequest re = null;
//        httpClient.getHttpConnectionManager().getParams();


//
//        DefaultHttpClient
//        cc.execute()
//        host.
//        method.set
//        method.set
//        Httpp


    }

    @Test
    public void testt() throws IOException {
        HttpClient httpClient = new HttpClient();
//        HostConfiguration host = new HostConfiguration();
//        host.setHost("localhost");
//        host.getParams().setParameter("http.protocol.content-charset", "UTF-8");
//        httpClient.setHostConfiguration(host);
//        httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY); // 设置 HttpClient 接收 Cookie,用与浏览器一样的策

        GetMethod method = new GetMethod("https://www.baidu.com/");
        method.addRequestHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        method.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        method.addRequestHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        method.addRequestHeader("Accept-Encoding", "gzip, deflate, br");
//        method.addRequestHeader("Connection", "keep-alive");
////        method.addRequestHeader("Cookie","BAIDUID=91D8E49892DF8B3D5CA3E11595454960:FG=1; BIDUPSID=91D8E49892DF8B3D5CA3E11595454960; PSTM=1543849168; BD_UPN=133252; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; H_PS_PSSID=1438_21100_27508; H_PS_645EC=f71fsdrEZ2zoZiw%2BPVUuLumJSYkRfXmLWgggwdcieULoND5cyi94MEdoDO0; delPer=0; BD_CK_SAM=1; PSINO=5; BDRCVFR[Fc9oatPmwxn]=mk3SLVN4HKm; locale=zh; BD_HOME=0");
//        method.addRequestHeader("Pragma","no-cache");
//        method.addRequestHeader("Cache-Control","no-cache");
//        method.addRequestHeader("Upgrade-Insecure-Requests","1");
//        method.addRequestHeader("Referer", "https://proxy.mimvp.com/freeopen.php?proxy=in_hp&sort=&page=2");
//        method.addRequestHeader("Cookie", "PHPSESSID=osarsetone4ouvn0j15mcpm1h5; Hm_lvt_51e3cc975b346e7705d8c255164036b3=1543892728; Hm_lpvt_51e3cc975b346e7705d8c255164036b3=1543896677");
//        method.addRequestHeader("Content-Type","text/html; charset=utf-8");

        //发起请求
        int executeMethod = httpClient.executeMethod(method);
//        System.out.println(method.getResponseCharSet());
//        System.out.println(method.getStatusLine().getStatusCode());


        GZIPInputStream gzin = new GZIPInputStream(method.getResponseBodyAsStream());
        BufferedInputStream br = new BufferedInputStream(gzin);
        String temp = "";
        StringBuffer result = new StringBuffer();
        byte[] bytes = new byte[1024];
        int n=0;
        while ((n = br.read(bytes)) != -1) {
//            String str = new String(temp.getBytes(), "UTF-8");
            String str = new String(bytes, 0, n);
            result.append(str + "\n");
        }
        System.out.println(result.toString());


//        DeflaterInputStream deflaterInputStream = new DeflaterInputStream();

//        String responseText = Utils.getStringFromInputStreamReader(isr);

//        StringBuffer result = new StringBuffer();
//        BufferedReader br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
//        String temp = "";
//        while ((temp = br.readLine()) != null) {
//            String str = new String(temp.getBytes(), "UTF-8");
//            result.append(str + "\n");
//        }
//        System.out.println(result);
//        //获取请求头
//        //获取响应,postMethod 提供两种方式,getResponseBodyAsString和getResponseBodyAsStream,但前者在没指定Content-length或者Content-length过长时会报错,推荐使用后者.
//        InputStream stream = method.getResponseBodyAsStream();
//        System.out.println(method.getResponseBodyAsString());
//        System.out.println(new String(method.getResponseBodyAsString().getBytes("ISO-8859-1"), "UTF-8"));

    }
}
