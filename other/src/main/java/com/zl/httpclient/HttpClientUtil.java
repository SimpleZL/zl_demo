package com.zl.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-12-05
 */
public class HttpClientUtil {
    public static String BX_CLINETINSTALL_URL = "http://bx.mrd.sohuno.com/api/userinfo/v1/clientInstall/getClientInstall.go";
    public static void main(String[] args) throws URISyntaxException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        URI uri = new URIBuilder("http://www.baidu.com/s").setParameter("wd","java").build();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response = client.execute(httpGet);
        System.out.println(EntityUtils.toString(response.getEntity()));

    }
}
