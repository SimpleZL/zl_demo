package com.zl.syn;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-12-04
 */
public class ThreadSafeSample {
    public int sharedState;

    public void nonSafeAction() {
        while (sharedState < 1000) {
            synchronized (this) {
                int former = sharedState++;
                int latter = sharedState;
                System.out.println("Observed data race, former is " + former + ", " + "latter is " + latter);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeSample threadSafeSample = new ThreadSafeSample();
        Thread threadA = new Thread(() -> threadSafeSample.nonSafeAction());
        threadA.start();
        threadA.wait();
        System.out.println("thread A wait");
        Thread.sleep(3000);
        threadA.notify();
        threadA.join();
    }
}
