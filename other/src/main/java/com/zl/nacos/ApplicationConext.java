package com.zl.nacos;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-07-17
 */
@Configuration
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "10.18.75.3:8848"))
@EnableNacosDiscovery(globalProperties = @NacosProperties(serverAddr = "10.18.75.3:8848"))
@NacosPropertySource(dataId = "example", autoRefreshed = true)
@ComponentScan(basePackages = "com.zl.nacos")
public class ApplicationConext {
}
