package com.zl.configCenter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-01-19
 */
public interface Property<T> {
    T getValue();

    T getDefaultValue();

    String getName();

    void getChangeedTimestamp();

    void addCallback(Runnable callBack);

    void removeCallbacks();
}
