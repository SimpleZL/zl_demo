package com.zl.reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-01-07
 */
public class TestInstrospector {
    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        ArticleBean articleBean = new ArticleBean();
        articleBean.setTitle("wo shi  biao ti");
        BeanInfo beanInfo = Introspector.getBeanInfo(articleBean.getClass(), Object.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        propertyDescriptors[0].getWriteMethod().invoke(articleBean,"我是标题");
        Object 我是标题 = propertyDescriptors[0].getReadMethod().invoke(articleBean);
        System.out.println(我是标题);
    }
}
