package com.zl.定时任务.springschedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-21
 */
@Service
public class HelloSpringTask {
    @Scheduled(fixedRate = 2)
    public void doTask() throws InterruptedException {
        Thread.sleep(4 * 1000);
        System.out.println(System.currentTimeMillis()+": hello  spring   task !");
    }
}
