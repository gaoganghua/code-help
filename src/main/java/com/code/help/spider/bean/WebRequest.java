package com.code.help.spider.bean;

import com.code.help.spider.enums.ParamTypeEnum;
import com.code.help.spider.enums.WebMethodEnum;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpVersion;
import org.springframework.util.StringUtils;

import java.util.Map;

public class WebRequest {
    private String url;

    private Map<String, String> headers;

    private NameValue[] params;

    private ParamTypeEnum paramType = ParamTypeEnum.STRING;

    private WebMethodEnum method = WebMethodEnum.GET;

    private Cookie cookie;

    private String charset = "UTF-8";

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

    public NameValue[] getParams() {
        return params;
    }

    public void setParams(NameValue[] params) {
        this.params = params;
    }

    public WebMethodEnum getMethod() {
        return method;
    }

    public void setMethod(WebMethodEnum method) {
        this.method = method;
    }

    public Cookie getCookie() {
        return cookie;
    }

    public void setCookie(Cookie cookie) {
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

    public void setParamType(ParamTypeEnum paramType) {
        this.paramType = paramType;
    }

    public void addHeader(String name, String value) {
        if (StringUtils.isEmpty(name)) {
            return;
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
