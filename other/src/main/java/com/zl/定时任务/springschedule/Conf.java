package com.zl.定时任务.springschedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-21
 */
@Configuration
@ComponentScan(basePackages = "com.zl.定时任务.springschedule")
@EnableScheduling
public class Conf {
}
