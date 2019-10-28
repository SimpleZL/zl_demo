package com.zl.定时任务.quartz;

import com.netflix.archaius.annotations.Configuration;
import org.quartz.JobDataMap;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-24
 */
@Configuration
@ComponentScan(basePackages = "com.zl.定时任务.quartz")
public class QuartzConfig {
    @Bean(name = "jobDetailFactoryBean")
    public JobDetailFactoryBean buildJobDetail(HelloJob helloJob) {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(helloJob.getClass());
        jobDetailFactoryBean.setDurability(true);
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("name", "Quartz");
        jobDetailFactoryBean.setJobDataMap(jobDataMap);
        return jobDetailFactoryBean;
    }

    @Bean(name = "simpleTrigger")
    public SimpleTriggerFactoryBean buildSimpleTrigger(JobDetailFactoryBean jobDetailFactoryBean) {
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        simpleTriggerFactoryBean.setStartDelay(0);
        simpleTriggerFactoryBean.setRepeatInterval(1000);
        return simpleTriggerFactoryBean;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactory(Trigger simpleTrigger) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(simpleTrigger);
        schedulerFactoryBean.setStartupDelay(1);
        return schedulerFactoryBean;
    }
}
