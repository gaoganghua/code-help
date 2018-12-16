package com.code.help.spider.bean;

import com.code.help.spider.enums.ParamTypeEnum;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.FilePartSource;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
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

    private HttpClientParams hostParams;

    private ProxyHost proxyHost;

    private Long timeout = 2L;

    public WebClient() {
        init();
    }

    public void build(Long timeout) {
        this.timeout = timeout;
    }

    public void build(HttpVersion version) {
        this.httpVersion = version;
    }

    public void build(String proxyHost, int port) {
        this.proxyHost = new ProxyHost(proxyHost, port);
    }

    public void init() {
        this.client = new HttpClient();
        buildHostParams();
        buildHostConfiguration();
    }

    private void buildHostParams() {
        if (hostParams == null) {
            client.getParams().setParameter(HttpClientParams.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
//        params.setParameter(HttpClientParams.SO_TIMEOUT, timeout);
        } else {
            client.setParams(hostParams);
        }
    }

    private void buildHostConfiguration() {
        if (hostConf == null) {
            client.getHostConfiguration().setHost("127.0.0.1");
            client.getHostConfiguration().setProxyHost(proxyHost);
        } else {
            client.setHostConfiguration(hostConf);
        }
    }

    public WebResponse execute(WebRequest request) throws IOException {
        buildProxyHost();
        HttpMethod method = buildMethod(request);
        buildHeaders(method, request);

        this.client.executeMethod(method);
        WebResponse response = buildResponse(method);
        return response;
    }


    private HttpMethod buildMethod(WebRequest request) throws UnsupportedEncodingException, FileNotFoundException {
        HttpMethod method = null;
        switch (request.getMethod().getValue()) {
            case "get":
                method = new GetMethod(request.getUrl());
                break;
            case "post":
                method = new PostMethod(request.getUrl());
                dealPostMethodParams(method, request);
                break;
            case "options":
                method = new OptionsMethod(request.getUrl());
                break;
            default:
                method = new GetMethod(request.getUrl());
        }

        if (StringUtils.isEmpty(request.getCharset())) {
            method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
            method.getParams().setParameter(HttpMethodParams.HTTP_ELEMENT_CHARSET, "UTF-8");
        } else {
            method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, request.getCharset());
            method.getParams().setParameter(HttpMethodParams.HTTP_ELEMENT_CHARSET, request.getCharset());
        }
        //填充httpMethodParamter参数
        if (request.getParams() != null) {
            for (NameValue nameValue : request.getParams()) {
                method.getParams().setParameter(nameValue.getName(), nameValue.getValue());
            }
        }

        return method;
    }

    private void dealPostMethodParams(HttpMethod method, WebRequest request) throws UnsupportedEncodingException, FileNotFoundException {
        PostMethod postMethod = (PostMethod) method;

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

    private void buildHeaders(HttpMethod method, WebRequest request) {
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
        if (headers == null || !headers.containsKey("Pragma")) {
            method.addRequestHeader("Pragma", "no-cache");
        }
        if (headers == null || !headers.containsKey("Cache-Control")) {
            method.addRequestHeader("Cache-Control", "no-cache");
        }

        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                method.addRequestHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    public void buildProxyHost(){

    }

    private WebResponse buildResponse(HttpMethod method) throws IOException {
        WebResponse response = new WebResponse();
        response.setStateCode(method.getStatusCode());
        response.setStatusLine(method.getStatusLine());
        response.setHeaders(processHeaders(method.getResponseHeaders()));
//        response.setCookie(method.getResponseHeader("cookie"));
        response.setStream(processStream(method.getResponseBodyAsStream(), method.getResponseHeader("Content-Encoding")));
        response.setCharset((String) method.getParams().getParameter(HttpMethodParams.HTTP_CONTENT_CHARSET));

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

    private InputStream processStream(InputStream stream, Header header) throws IOException {
        String encoding = null;
        if (header == null) {
            return new BufferedInputStream(stream);
        }
        encoding = header.getValue();
        InputStream resultStream = stream;

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
