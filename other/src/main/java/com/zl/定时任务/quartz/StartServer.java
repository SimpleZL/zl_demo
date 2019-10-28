package com.zl.定时任务.quartz;

import com.netflix.archaius.annotations.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-24
 */

public class StartServer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(QuartzConfig.class);
        System.out.println("容器加载完毕!");
    }
}
