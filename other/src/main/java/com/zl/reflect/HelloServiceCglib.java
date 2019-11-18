package com.zl.reflect;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-31
 */
public class HelloServiceCglib implements MethodInterceptor {
    private Object target;
    public Object getInstance(Object object){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("=====我是CGLIB动态代理==============");
        Object result = null;
        System.err.println("我准备说hello");
        result = methodProxy.invokeSuper(o,objects);
        return result;
    }
}
