package com.code.help.web_driver;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MIfangTokenTest {
    @Test
    public void test(){

    }

    public InputStream getResponse(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder().url(url).build();
        Response resp = client.newCall(req).execute();
        InputStream is = resp.body().byteStream();
        return is;
    }
}
