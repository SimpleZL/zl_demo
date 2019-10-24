package com.zl.httpclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-03-26
 */
@Slf4j
public class HttpClientWithHandler {
    public static void main(String[] args) {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        try {
            URIBuilder httpUri = new URIBuilder("http://service.k.sohu.com/api/videotab/inner/getTvPlayCounts.go");
            httpUri.addParameter("newsId", "346623745");
            HttpGet httpGet = new HttpGet(httpUri.build());
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                    HttpEntity entity = response.getEntity();
                    return EntityUtils.toString(entity);
                }
            };
            String response = closeableHttpClient.execute(httpGet, responseHandler);
            System.out.println(response);
        } catch ( Exception e ) {
            log.error("[http error] uri is ", e);
        } finally {
            try {
                closeableHttpClient.close();
            } catch ( IOException e ) {
                e.printStackTrace();
            }
        }
    }
}
