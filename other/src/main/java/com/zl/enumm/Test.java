package com.zl.enumm;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 赋予枚举行为的方法
 *
 * @author: liangzhang212928
 * @Date: 2020-01-07
 */
public enum Test {
    /**
     * 可以利用责任链模式
     */
    VIDEOSERVICE("videoService") {
        @Override
        public DynamicBindService getService() {
            return (DynamicBindService) new Object();
        }
    };

    Test(String assemblyService) {
        this.assemblyService = assemblyService;
    }

    private String assemblyService;

    public abstract DynamicBindService getService();
}
