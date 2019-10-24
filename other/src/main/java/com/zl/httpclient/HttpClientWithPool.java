package com.zl.httpclient;

import com.alibaba.fastjson.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-04-02
 */
public class HttpClientWithPool {
    public static void main(String[] args) {
        String ss = "{\"ttime\":\"27280.000000\"}";
        JSONObject jsonObject = JSONObject.parseObject(ss);
        System.out.println(jsonObject.getDoubleValue("ttime"));

    }
}
