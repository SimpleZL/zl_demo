package zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-08-23
 */
public class ZkLock {
    public static void main(String[] args) {
        CuratorFramework curatorFramework = ZLZKFactory.getClient();
        InterProcessMutex lock = new InterProcessMutex(curatorFramework, "/smc/lock");
        ExecutorService executors = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            executors.submit(() -> {
                try {
                    if (lock.acquire(1000, TimeUnit.MILLISECONDS)) {
                        System.out.println("获取锁");
                        Thread.sleep(3000);
                        lock.release();
                    } else {
                        System.out.println("未获取锁，不执行！");
                    }
                } catch ( Exception e ) {
                    e.printStackTrace();
                }
            });
        }
    }
}
