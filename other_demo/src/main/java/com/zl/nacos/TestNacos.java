package com.zl.nacos;

import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-07-17
 */
public class TestNacos {
    public static void main(String[] args) throws NacosException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConext.class);
        ConfigService configService = applicationContext.getBean("configService", ConfigService.class);
        DiscoveryService discoveryService = applicationContext.getBean("discoveryService",DiscoveryService.class);
        System.out.println(configService.printLocalCache());
        System.out.println(configService.printTest());
        System.out.println(discoveryService.getRemoteService("test"));

    }
}
