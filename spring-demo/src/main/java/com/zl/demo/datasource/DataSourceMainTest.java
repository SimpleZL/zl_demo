package com.zl.demo.datasource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-02-19
 */
@SuppressWarnings("deprecation")
public class DataSourceMainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        MyTestBean bean = context.getBean(MyTestBean.class);
        System.out.println(bean.getTestStr());
    }
}
