package com.zl.spi;

import java.util.ServiceLoader;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-02-21
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<PrintService> serviceLoaders = ServiceLoader.load(PrintService.class);
        for (PrintService printService : serviceLoaders) {
            printService.printInfo();
        }
        System.exit(1);
    }
}
