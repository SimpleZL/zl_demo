package com.zl.efftivejava.chapter1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * created by liangzhang212928
 * on 2019/11/20
 */
public class Services {
    private Services() {
    }

    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    /**
     * 服务注册者api
     *
     * @param p
     */
    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }

    public static Service NewInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if (p == null) {
            throw new IllegalArgumentException("NO provider registered with name: " + name);
        }
        return p.newService();
    }
}
