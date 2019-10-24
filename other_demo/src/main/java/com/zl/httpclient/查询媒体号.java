package com.zl.httpclient;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-06-12
 */
public class 查询媒体号 {
    public static void main(String[] args) throws IOException, URISyntaxException {

        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        File file = new File("C:\\Users\\liangzhang212928\\Desktop\\昵称.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String pid = reader.readLine();
            while (StringUtils.isNotBlank(pid)) {
                pid = pid.replaceAll(" ", "");
                URIBuilder httpUri = new URIBuilder("http://news-search.irp.sohuno.com/mrd-search-service/recomMedia/mediaSearch?page=1&pageSize=38&cid=123456&userType=10");
                httpUri.addParameter("keywords", pid);
                HttpGet httpGet = new HttpGet(httpUri.build());
                CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
                HttpEntity entity = response.getEntity();
                String jsonObject = EntityUtils.toString(entity);
                JSONObject jsonObject1 = JSONObject.parseObject(jsonObject);
                JSONArray jsonArray = jsonObject1.getJSONArray("items");
                if (jsonArray == null || jsonArray.size() == 0) {
                    System.out.println("N/A");
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    if (jsonArray.size() > 1) {
                        for (Object object : jsonArray) {
                            JSONObject jsonObject2 = (JSONObject) object;
                            stringBuilder.append(jsonObject2.getString("newsid"));
                            stringBuilder.append("&");
                        }
                        System.out.println(stringBuilder.toString());
                    } else {
                        for (Object object : jsonArray) {
                            JSONObject jsonObject2 = (JSONObject) object;
                            System.out.println(jsonObject2.getString("newsid"));
                        }
                    }


                }
                //查询pid
//                JSONObject jsonObject1 = JSONObject.parseObject(jsonObject);
//                JSONObject data = jsonObject1.getJSONObject("data");
//                System.out.println(data.getString("nickName"));
                pid = reader.readLine();
            }
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
