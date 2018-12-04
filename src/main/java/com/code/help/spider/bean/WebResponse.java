package com.code.help.spider.bean;

import com.code.help.spider.util.IOUtils;
import org.apache.commons.httpclient.Cookie;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class WebResponse {
    private int stateCode;

    private String stateLine;

    private Cookie cookie;

    private Map<String, String> headers;

    private InputStream stream;

    private String body;

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateLine() {
        return stateLine;
    }

    public void setStateLine(String stateLine) {
        this.stateLine = stateLine;
    }

    public Cookie getCookie() {
        return cookie;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }

    public String getBody() throws IOException {
        try {
            return IOUtils.parseStream(this.getStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
