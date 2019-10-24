package com.zl.httpclient;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.sohu.smc.config.enums.EnvEnum;
import com.sohu.smc.config.model.AppConfiguration;
import com.sohu.smc.config.util.EnvHelper;
import lombok.extern.log4j.Log4j2;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-04-25
 */
public class Profile {
    public static void main(String[] args) {
        Profile profile = new Profile();
        profile.getNewsIdList(6462608627487649861L);
    }

    public List<String> getNewsIdList(long pid) {
        List<String> newsIds = Lists.newArrayList();
        int cursorIdOld = 0;
        try {
            int cursorId = getCursor(pid, newsIds, cursorIdOld);
            while (cursorId != cursorIdOld) {
                cursorIdOld = cursorId;
                cursorId = getCursor(pid, newsIds, cursorIdOld);
            }
            for (int i = 0; i < newsIds.size(); i++) {
                CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
                URIBuilder httpUri = new URIBuilder("http://service.k.sohu.com/api/videotab/updateByNewsId.go");
                httpUri.addParameter("newsId", newsIds.get(i));
                HttpGet httpGet = new HttpGet(httpUri.build());
                System.out.println("Excute uri " + httpGet.getURI());
                CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
                String result = EntityUtils.toString(response.getEntity());
                System.out.println(result);
                closeableHttpClient.close();
            }
        } catch ( Exception e ) {
//            log.in.error("获取媒体号文章出错", e);
        }
        if (EnvHelper.getEnvType() != EnvEnum.online) {
//            ApiLogger.info("pid is {},newsId List is{}", pid, JSONObject.toJSONString(newsIds));
        }
        return newsIds;
    }

    public List<String> getNewsIdListFallback(long pid) {
//        ApiLogger.warn("获取媒体号下文章列表熔断!!!");
        return Lists.newArrayList();
    }

    /**
     * @param pid        媒体号pid
     * @param newsIdList 文章类表
     * @param cursorId   游标id
     * @return 新的游标Id
     */
    private int getCursor(long pid, List<String> newsIdList, int cursorId) throws URISyntaxException, IOException {
        String uri = AppConfiguration.getString("smc.recom.videotab.profile", "http://attn-api.bx.irp.sohuno.com/lina/feed/getUserFeedsV2.do?pid=%d&pageSize=50&cursorId=%d&from=zl").get();
        String url = String.format(uri, pid, cursorId);
//        ApiLogger.info("[获取媒体号文章] " + url);
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        URIBuilder httpUri = new URIBuilder(url);
        HttpGet httpGet = new HttpGet(httpUri.build());
        System.out.println("Excute uri " + httpGet.getURI());
        CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
        String result = EntityUtils.toString(response.getEntity());
        JSONObject resultJSONObject = JSONObject.parseObject(result);
        JSONObject info = resultJSONObject.getJSONObject("info");
        JSONObject data = resultJSONObject.getJSONObject("data");
        cursorId = data.getIntValue("cursor");
        Assert.assertNotNull(info);
        Assert.assertNotNull(data);
        if (info.getIntValue("code") == 200) {
            JSONArray datas = data.getJSONArray("datas");
            if (datas != null) {
                for (int i = 0; i < datas.size(); i++) {
                    JSONObject var = datas.getJSONObject(i);
                    String newsId = var.getString("itemId");
                    newsIdList.add(newsId);
                }
            }
        }
        closeableHttpClient.close();
        return cursorId;
    }
}
