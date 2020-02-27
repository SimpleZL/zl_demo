package com.zl.httpclient;

import com.sohu.smc.api.util.common.HttpClientWrapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-02-18
 */
public class Test {
    public static void main(String[] args) {
        String responseBodyAsString = HttpClientWrapper.getResponseBodyAsString("http://sa.sogou.com/new-weball/page/sgs/epidemic");
        System.out.println(responseBodyAsString);
    }
}
