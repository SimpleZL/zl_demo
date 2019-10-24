package com.zl.定时任务.springschedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * spring scheduler
 * TaskExecutor 任务执行器  -相当于Java的SchedulerExecutorservice
 * TaskScheduler 包含一些列调度的任务的方法 --
 * Trigger- 调度策略
 * 问题：注解形式 如何设置线程数以及队列策略      ---https://blog.csdn.net/yyx1025988443/article/details/78698046
 *
 * @author: liangzhang212928
 * @Date: 2019-10-21
 */
public class T {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            Date parse = simpleDateFormat.parse("20200921");
            System.out.println(parse.getTime());
            System.out.println(System.currentTimeMillis());
        } catch ( ParseException e ) {

        }

    }
}
