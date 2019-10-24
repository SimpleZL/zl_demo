package com.zl.定时任务.timer;

import java.util.Timer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-21
 */
public class HelloTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // ms
        timer.scheduleAtFixedRate(new HelloTimerTask(),1000,10 * 1000);
    }
}
