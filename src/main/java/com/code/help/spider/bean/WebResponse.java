package com.code.help.spider.bean;

import com.code.help.spider.util.IOUtils;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.StatusLine;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class WebResponse {
    private int stateCode;

    private StatusLine statusLine;

    private Cookie cookie;

    private Map<String, String> headers;

    private InputStream stream;

    private String body;

    private String charset;

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public StatusLine getStatusLine() {
        return statusLine;
    }

    public void setStatusLine(StatusLine statusLine) {
        this.statusLine = statusLine;
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
        if (!StringUtils.isEmpty(body)) {
            return body;
        }
        try {
            body = IOUtils.parseStream(this.getStream(), charset);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }
}
