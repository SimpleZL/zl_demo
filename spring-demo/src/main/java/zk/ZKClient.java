package zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-01-20
 */
public class ZKClient {
    public static void main(String[] args) {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
        String conInfo = "zkbx1.mrd.sohuno.com,zkbx2.mrd.sohuno.com,zkbx3.mrd.sohuno.com,zkbx4.mrd.sohuno.com,zkbx5.mrd.sohuno.com";
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(conInfo,retryPolicy);
        curatorFramework.start();
//        curatorFramework.create().forPath("/")
    }
}
