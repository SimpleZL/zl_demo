package com.zl.threadpool;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-04-04
 */
public class TestRunner implements Runnable{
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */

    public void run() {
        try {
            Thread.sleep(1000);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());
        System.out.println();
    }
}
