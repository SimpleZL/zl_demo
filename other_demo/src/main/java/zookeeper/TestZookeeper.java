package zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-08-23
 */
public class TestZookeeper {
    public static void main(String[] args) {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(ZkAddress.address, retryPolicy);
        client.start();
        try {
            client.create().forPath("/smc/config/develop/smc.h5.test.zk","test".getBytes());
        } catch ( Exception e ) {
            e.printStackTrace();
        }finally {
            client.close();
        }
    }
}
