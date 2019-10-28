package com.zl.定时任务.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-24
 */

@Component
public class HelloJob implements Job {
    private String name;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(String.format("hello %s", name));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
