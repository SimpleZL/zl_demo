package com.zl.spi;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-02-21
 */
public class PrintServiceImpl implements PrintService {
    @Override
    public void printInfo() {
        System.out.println("hello word spi !");
    }
}
