package com.zl.nacos;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 服务发现示例
 *
 * @author: liangzhang212928
 * @Date: 2019-07-17
 */
@Service(value = "discoveryService")
public class DiscoveryService {
    @NacosInjected
    private NamingService namingService;

    public List<Instance> getRemoteService(String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }
}
