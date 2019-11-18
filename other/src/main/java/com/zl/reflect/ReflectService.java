package com.zl.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-31
 */
public class ReflectService {
    public void sayHello(String name) {
        System.out.println("hell0 " + name);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object reflectService = Class.forName(ReflectService.class.getName()).newInstance();
        Method sayHello = reflectService.getClass().getMethod("sayHello", String.class);
        sayHello.invoke(reflectService,"reflect");

    }
}
