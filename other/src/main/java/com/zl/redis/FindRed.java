package com.zl.redis;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-01-22
 */
public class FindRed {
    public static void main(String[] args) throws IOException {
        String key = "smc:new:redpack:hasReceivedCid:112";
        Jedis jedis = JedisUtil.getJedis();
        Set<String> cids =  jedis.hkeys(key);

        for (String cid: cids){
            if (cid.equals("6128377411404214296")){
                System.out.println(cid);
                System.out.println(jedis.hget(key,cid));
            }
        }
//        Jedis jedis = JedisUtil.getJedis();
//        File files = new File("C:\\\\Users\\\\liangzhang212928\\\\Desktop\\\\20190122");
//        File[] listFiles = files.listFiles();
//        int i = 1;
//        List arrayList = new ArrayList();
//        for (File tmp : listFiles) {
//            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tmp)));
//            String message = br.readLine();
//            while (StringUtils.isNotBlank(message)) {
//                String[] ssTmp = message.split("\\|");
//                String jsonString = ssTmp[1];
//                JSONObject jsonObject = JSONObject.parseObject(jsonString);
//                String key = "smc:new:redpack:hasReceivedCid:93";
//                String cid = jsonObject.getString("cid");
//                if (jedis.hexists(key, cid)) {
//                } else {
//                    System.out.println(cid);
//                }
//
//                if (arrayList.contains(cid)) {
//                    System.out.println(cid);
//                } else {
//                    arrayList.add(cid);
//                }
//                message = br.readLine();
//                i++;
//            }
//        }
//        jedis.close();
    }

}
