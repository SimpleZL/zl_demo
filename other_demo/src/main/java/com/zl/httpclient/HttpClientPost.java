package com.zl.httpclient;

import com.google.common.collect.Lists;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-04-01
 */
public class HttpClientPost {
    public static void main(String[] args) throws IOException, URISyntaxException {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder("http://service.k.sohu.com/api/videotab/inner/getTvPlayCounts.go");
        uriBuilder.addParameter("newsId", "346623745");
        HttpPost httpPost = new HttpPost(uriBuilder.build());
//        List<NameValuePair> list = Lists.newArrayList();
//        list.add(new BasicNameValuePair("newsId", "346623745"));
//        httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
        CloseableHttpResponse response = closeableHttpClient.execute(httpPost);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
