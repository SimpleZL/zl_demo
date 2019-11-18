package com.zl.reflect;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-31
 */
public class HelloServiceMain {
    public static void main(String[] args) {
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
        HelloService helloService = (HelloService) helloServiceProxy.bind(new HelloServiceImpl());
        helloService.sayHello("张三");
    }
}
