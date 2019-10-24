package com.zl.other;


import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-02-18
 */
public class TestInvoke {
    public static void target(int index) {
        new Exception("#" + index).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> classF = Class.forName("com.zl.other.TestInvoke");

        Method method = classF.getMethod("target", int.class);
        method.invoke(null, 1);

    }
}
