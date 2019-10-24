package com.zl.jedisFactory;

import com.sohu.smc.api.util.redis.factory.JedisFactory;
import com.sohu.smc.api.util.redis.model.JedisBean;
import redis.clients.jedis.JedisPoolConfig;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-06-20
 */
public class JedisSohuTest {
    static JedisFactory jedisFactory = null;
    static String lightAppRedis = "smc.redis.abtest.common";

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxWaitMillis(100);
        JedisBean jedisBean = new JedisBean();
        jedisBean.setConfCenterKey(lightAppRedis);
        jedisFactory = new JedisFactory(jedisBean, jedisPoolConfig);
    }

    public void writerFile(String keyMoment) throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\资料\\sohu\\2019\\6月份\\时刻品牌专区ab\\显示品牌专区.txt");
        Set<String> cids = jedisFactory.smembers(keyMoment);
        int i = 0;
        for (String cid : cids) {
            fileWriter.append(cid + "\n");
        }
        fileWriter.close();
    }

    private static class PushHistory {
        int newsId;
        int channelNewsId;
        long pushTime;

        public int getNewsId() {
            return newsId;
        }

        public void setNewsId(int newsId) {
            this.newsId = newsId;
        }

        public int getChannelNewsId() {
            return channelNewsId;
        }

        public void setChannelNewsId(int channelNewsId) {
            this.channelNewsId = channelNewsId;
        }

        public long getPushTime() {
            return pushTime;
        }

        public void setPushTime(long pushTime) {
            this.pushTime = pushTime;
        }
    }

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\liangzhang212928\\Desktop\\普通红点1.txt");
        String keyMoment = "abtest:groupKey:C:online:2";
        Set<String> cids = jedisFactory.smembers(keyMoment);
        int i = 0;
        for (String cid : cids) {
//            if (jedisFactory.sismember("abtest:groupKey:A:online:2", String.valueOf(cid))) {
//                continue;
//            }
            String co = String.format("\"%s\"", cid);
            fileWriter.append(co + "\n");
        }
        fileWriter.close();

    }
//        String key = "abtest:groupKey:B:online:momentTab";
//        String keyMoment = "abtest:groupKey:moment:brandonline";
//        FileReader fileReader = new FileReader("C:\\Users\\liangzhang212928\\Desktop\\sohutimetab_cid");
//        BufferedReader reader = new BufferedReader(fileReader);
//        String line = reader.readLine();
//        List<String> lists = new ArrayList<>();
//        while (StringUtils.isNotBlank(line)) {
//            lists.add(line);
//            if (lists.size() >= 500000) {
//                long count = jedisFactory.sadd(keyMoment, lists);
//                System.out.println(count);
//                lists = new ArrayList<>();
//            }
//            line = reader.readLine();
//        }
//        System.out.println(lists.size());
//        long count = jedisFactory.sadd(keyMoment, lists);
//        System.out.println(count);
//
//    }

}
