package com.code.help.spider.bean;

import com.code.help.spider.enums.ParamTypeEnum;
import com.code.help.spider.enums.WebMethodEnum;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpVersion;

import java.util.Map;

public class WebRequest {
    private String url;

    private Map<String, String> headers;

    private NameValue[] params;

    private ParamTypeEnum paramType;

    private WebMethodEnum method = WebMethodEnum.GET;

    private Cookie cookie;

    private HttpVersion version;

    private String charset;

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

    public HttpVersion getVersion() {
        return version;
    }

    public void setVersion(HttpVersion version) {
        this.version = version;
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

}
