package com.zl.nacos;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Cluster;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.api.naming.pojo.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 注册服务
 *
 * @author: liangzhang212928
 * @Date: 2019-07-18
 */
public class RegisterService {
    public static void main(String[] args) throws NacosException {
        NamingService namingService = NamingFactory.createNamingService("10.18.75.3:8848");
        //只是简单的信息
        namingService.registerInstance("test", "test", 1);
        // 比上面的方式多了集群信息
        Instance instance = new Instance();
        instance.setIp("10.18.75.3");
        instance.setPort(8061);
        instance.setHealthy(true);
        instance.setWeight(2.0);
        Map<String, String> instanceMap = new HashMap<>();
        instanceMap.put("site", "et2");
        instance.setMetadata(instanceMap);
//        namingService.registerInstance("testApi",instance);

        Service service = new Service("com.zl.test");
        service.setAppName("article");
        service.setGroupName("article-test");
        Map<String, String> serviceMeta = new HashMap<>();
        serviceMeta.put("symmetricCall", "true");
        service.setMetadata(serviceMeta);
        instance.setServiceName("com.zl.test");

        Cluster cluster = new Cluster();
        cluster.setName("1111111111");
        Map<String, String> clusterMeta = new HashMap<>();
        clusterMeta.put("xxx", "yyy");
        cluster.setMetadata(clusterMeta);

        instance.setClusterName("1111111111");

        namingService.registerInstance("final", instance);


    }
}
