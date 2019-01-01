package com.code.help.spider.bean;

import com.code.help.spider.enums.ParamTypeEnum;
import com.code.help.spider.enums.WebMethodEnum;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpVersion;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WebRequest {
    private String url;

    private Map<String, String> headers;

    private List<NameValue> reqParams;

    private Map<String, Object> methodParams;

    private ParamTypeEnum paramType = ParamTypeEnum.STRING;

    private WebMethodEnum method = WebMethodEnum.GET;

    private String cookie;

    private String charset = "UTF-8";

    private HttpVersion httpVersion = HttpVersion.HTTP_1_1;

    public WebRequest() {
    }

    public WebRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public List<NameValue> getReqParams() {
        return reqParams;
    }

    public void addReqParams(String paramName, Object paramValue) {
        if (StringUtils.isEmpty(paramName)) {
            return;
        }
        if (reqParams == null) {
            reqParams = new LinkedList<>();
        }
        this.reqParams.add(new NameValue(paramName, paramValue));
    }

    public void setReqParams(List<NameValue> reqParams) {
        this.reqParams = reqParams;
    }

    public Map<String, Object> getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(Map<String, Object> methodParams) {
        this.methodParams = methodParams;
    }

    public WebMethodEnum getMethod() {
        return method;
    }

    public void setMethod(WebMethodEnum method) {
        this.method = method;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public ParamTypeEnum getParamType() {
        return paramType;
    }

    public HttpVersion getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(HttpVersion httpVersion) {
        this.httpVersion = httpVersion;
    }

    public void setParamType(ParamTypeEnum paramType) {
        this.paramType = paramType;
    }

    public void addHeader(String name, String value) {
        if (StringUtils.isEmpty(name)) {
            return;
        }
        if (headers == null) {
            headers = new HashMap<>();
        }

        headers.put(name, value);
    }

    public String getHeader(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        return headers.get(name);
    }

}
