package com.zl.configCenter;

import java.lang.invoke.MethodType;
import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-02-03
 */
public class Dynamic {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 321;
        Long g = 3L;
        System.out.println(c == (a+b));
        System.out.println(c .equals (a+b));
        System.out.println(g == (a+b));
        System.out.println(Duration.ofSeconds(100));
    }
}
