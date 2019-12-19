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
        //1. 根据名字
        Class<?> aClass = Class.forName(ReflectService.class.getName());
        // 2. 直接调用class
        Class<ReflectService> reflectServiceClass = ReflectService.class;
        // 3. 通过对象
        ReflectService reflectService1 = new ReflectService();
        Class<? extends ReflectService> aClass1 = reflectService1.getClass();
        Object reflectService = aClass.newInstance();
        Method sayHello = reflectService.getClass().getMethod("sayHello", String.class);
        sayHello.invoke(reflectService,"reflect");

    }
}
