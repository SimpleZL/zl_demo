package com.zl.syn;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-07-02
 */
public class TestSyn {
    /**
     * 普通方法
     *
     * @param i
     * @return
     */
    public synchronized int add(int i) {
        return i++;
    }

    /**
     * 同步代码块
     *
     * @param m
     * @return
     */
    public int rm(int m) {
        synchronized (TestSyn.class) {
            m = m--;
        }
        return m;
    }
}
