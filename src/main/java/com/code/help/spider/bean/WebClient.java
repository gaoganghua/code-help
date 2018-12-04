package com.code.help.spider.bean;

import com.code.help.spider.enums.ParamTypeEnum;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.FilePartSource;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.DeflaterInputStream;
import java.util.zip.GZIPInputStream;

public class WebClient {
    private HttpVersion httpVersion = HttpVersion.HTTP_1_1;

    private HostConfiguration hostConf;

    private HttpClient client;

    private int timeout;

    public WebClient() {
        init();
    }

    public WebClient(HttpClient client) {
        this.client = client;
    }

    public void init() {
        client = new HttpClient();
        HostConfiguration conf = new HostConfiguration();
//        conf.setHost("localhost");
//        client.getHostConfiguration().setProxy("localhost", 8888);
    }

    public void init(int timeout) {
        client = new HttpClient();
        client.getParams().setSoTimeout(timeout);
    }

    public void init(int timeout, HostConfiguration conf) {
        client = new HttpClient();
        client.getParams().setSoTimeout(timeout);
        client.setHostConfiguration(conf);
    }

    public WebResponse execute(WebRequest request) throws IOException {
        HttpMethod method = convert(request);
        fillHeaders(method, request);

        System.out.println(method == null);
        System.out.println(client == null);
        this.client.executeMethod(method);
        WebResponse response = build(method);
        return response;
    }

    private HttpMethod convert(WebRequest request) throws UnsupportedEncodingException, FileNotFoundException {
        HttpMethod method = null;
        switch (request.getMethod().getValue()) {
            case "get":
                method = new GetMethod();
                break;
            case "post":
                method = new PostMethod();
                dealPostMethodParams(method, request);
                break;
            case "options":
                method = new OptionsMethod();
                break;
            default:
                method = new GetMethod();
        }

        return method;
    }

    private void dealPostMethodParams(HttpMethod method, WebRequest request) throws UnsupportedEncodingException, FileNotFoundException {
        PostMethod postMethod = (PostMethod) method;
        if (StringUtils.isEmpty(request.getCharset())) {
            ((PostMethod) method).setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        } else {
            ((PostMethod) method).setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, request.getCharset());
        }
        //两种方法作用相同
//        ((PostMethod) method).addParameters(request.getMethodParams());
//        ((PostMethod) method).setRequestBody();
        RequestEntity requestEntity = null;
        if (ParamTypeEnum.STRING.equals(request.getParamType())) {
            StringBuffer params = new StringBuffer();
            for (NameValue nameValue : request.getParams()) {
                params.append(nameValue.getName() + "=" + String.valueOf(nameValue.getValue()));
                params.append("&");
            }
            params.deleteCharAt(params.length() - 1);
            requestEntity = new StringRequestEntity(params.toString(), null, "UTF-8");
        } else if (ParamTypeEnum.BYTEARRAY.equals(request.getParamType())) {
            StringBuffer params = new StringBuffer();
            for (NameValue nameValue : request.getParams()) {
                params.append(nameValue.getName() + "=" + String.valueOf(nameValue.getValue()));
                params.append("&");
            }
            params.deleteCharAt(params.length() - 1);
            requestEntity = new ByteArrayRequestEntity(params.toString().getBytes("UTF-8"));
        } else if (ParamTypeEnum.MULTIPART.equals(request.getParamType())) {
            List<Part> parts = new LinkedList<>();
            for (NameValue nameValue : request.getParams()) {
                if (nameValue.getValue() instanceof File) {
                    parts.add(new FilePart(nameValue.getName(), new FilePartSource((File) nameValue.getValue())));
                } else {
                    parts.add(new StringPart(nameValue.getName(), String.valueOf(nameValue.getValue())));
                }
            }
        }
        postMethod.setRequestEntity(requestEntity);
    }

    private void fillHeaders(HttpMethod method, WebRequest request) {
        Map<String, String> headers = request.getHeaders();

        if (headers == null || !headers.containsKey("User-Agent")) {
            method.addRequestHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0");
        }
        if (headers == null || !headers.containsKey("Accept")) {
            method.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        }
        if (headers == null || !headers.containsKey("Accept-Language")) {
            method.addRequestHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        }
        if (headers == null || !headers.containsKey("Accept-Encoding")) {
            method.addRequestHeader("Accept-Encoding", "gzip, deflate, br");
        }
        if (headers == null || !headers.containsKey("Connection")) {
            method.addRequestHeader("Connection", "keep-alive");
        }

        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                method.addRequestHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    private WebResponse build(HttpMethod method) throws IOException {
        WebResponse response = new WebResponse();
        response.setStateCode(method.getStatusCode());
        response.setStateLine(method.getStatusLine().toString());
        response.setHeaders(processHeaders(method.getResponseHeaders()));
        response.setStream(processStream(method.getResponseBodyAsStream(), method.getResponseHeaders()));

        return response;
    }

    private Map<String, String> processHeaders(Header[] headers) {
        if (headers == null || headers.length == 0) {
            return null;
        }
        Map<String, String> mapheaders = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            mapheaders.put(headers[i].getName(), headers[i].getValue());
        }
        return mapheaders;
    }

    private InputStream processStream(InputStream stream, Header[] headers) throws IOException {
        String encoding = null;
        InputStream resultStream = stream;
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].getName() == "Content-Encoding") {
                encoding = headers[i].getValue();
            }
        }
        if (!StringUtils.isEmpty(encoding)) {
            if ("gzip".equals(encoding) || "zip".equals(encoding)) {
                GZIPInputStream gzin = new GZIPInputStream(stream);
                resultStream = new BufferedInputStream(gzin);
            } else if ("deflate".equals(encoding)) {
                DeflaterInputStream dis = new DeflaterInputStream(stream);
                resultStream = new BufferedInputStream(dis);
            }

        }
        return resultStream;
    }
}
