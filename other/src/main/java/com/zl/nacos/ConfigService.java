package com.zl.nacos;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-07-17
 */
@Service(value = "configService")
public class ConfigService {
    @NacosValue(value = "${userLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;
    @NacosValue(value = "${test:}", autoRefreshed = true)
    private String test;
    public boolean printLocalCache() {
        return useLocalCache;
    }

    public String printTest(){
        return test;
    }
}
