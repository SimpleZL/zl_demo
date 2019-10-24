package com.zl.定时任务.schedulerservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-21
 */
public class HelloSchedulerExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        //速率-每隔1秒执行一次
        scheduledExecutorService.scheduleAtFixedRate(new RunCase(), 100, 1000, TimeUnit.MILLISECONDS);
        //每次case 执行完毕之后 ，再次间隔1s时间执行下一次操作;当前case间隔为 2+1 秒
        scheduledExecutorService.scheduleWithFixedDelay(new RunCase(), 100, 1000, TimeUnit.MILLISECONDS);
    }
}
