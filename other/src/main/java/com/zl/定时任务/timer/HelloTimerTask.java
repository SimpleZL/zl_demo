package com.zl.定时任务.timer;

import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-21
 */
public class HelloTimerTask extends TimerTask {
    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        System.out.println("hello java timer");
    }
}
