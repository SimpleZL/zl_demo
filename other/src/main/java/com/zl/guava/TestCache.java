package com.zl.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-12-10
 */
public class TestCache {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LoadingCache<String,String>  loacleCache = CacheBuilder.newBuilder().maximumSize(10).expireAfterWrite(10, TimeUnit.SECONDS).recordStats().build(new CacheLoader<String, String>() {
            @Override
            public String load(String s) throws Exception {
                return "null";
            }
        });
        while (true){
            loacleCache.put("111","2222");
            loacleCache.put("1112","22222");
            loacleCache.put("11122","222222");
            loacleCache.put("111222","2222");
            loacleCache.put("1112222","2222");
            Thread.sleep(10 * 1000);
            String test = loacleCache.get("111");
        }

    }
}
