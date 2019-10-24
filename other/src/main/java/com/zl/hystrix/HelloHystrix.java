package com.zl.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-11-08
 */
public class HelloHystrix extends HystrixCommand<String> {
    protected HelloHystrix(HystrixCommandGroupKey group) {
        super(HystrixCommandGroupKey.Factory.asKey("hello"));
    }

    @Override
    protected String run() {

        return "hello,hystrix";
    }

    @Override
    protected String getFallback() {
        return super.getFallback();
    }
}
