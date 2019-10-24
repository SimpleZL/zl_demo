package com.zl.定时任务.springschedule;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-21
 */
public class TestMain {
    public static void main(String[] args) {
        ApplicationContext  applicationContext = new AnnotationConfigApplicationContext(Conf.class);
        System.out.println("初始化成功!");
    }
}
