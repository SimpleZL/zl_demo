package com.zl.httpclient;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

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
        URI uri = new URIBuilder("http://sa.sogou.com/new-weball/page/sgs/epidemic").build();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response = client.execute(httpGet);
        String htmlResponse = EntityUtils.toString(response.getEntity(), "utf-8");
        Document document = Jsoup.parse(htmlResponse);
        Element body = document.selectFirst("body");
        Element script = body.selectFirst("script");
        String content = script.html();
        String flag = "window.__INITIAL_STATE__ =";
        int index = content.indexOf(flag)+flag.length();
        String defData = content.substring(index ,content.length());
        JSONObject jsonObject = JSONObject.parseObject(defData);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONObject domesticStats = data.getJSONObject("domesticStats");
        System.out.println(domesticStats.toJSONString());
    }
}
