package com.zl.efftivejava.chapter1;

/**
 * created by liangzhang212928
 * on 2019/11/22
 * 枚举类型强化单列模式
 */
public enum EnumSingleton {
    ServiceFrameWork;
    private ServerFrameWork serverFrameWork;

    private EnumSingleton() {
        serverFrameWork = new ServerFrameWork();
    }

    public ServerFrameWork getService() {
        return serverFrameWork;
    }
}
