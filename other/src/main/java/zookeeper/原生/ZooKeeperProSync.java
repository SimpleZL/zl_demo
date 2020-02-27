package zookeeper.原生;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-02-25
 */
public class ZooKeeperProSync implements Watcher {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zooKeeper;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        String path = "/mydata/dev";
        zooKeeper = new ZooKeeper("localhost:2181", 5000, new ZooKeeperProSync());
        System.out.println(new String(zooKeeper.getData(path, true, stat)));
        countDownLatch.await();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
          if (Event.KeeperState.SyncConnected == watchedEvent.getState()){
              if (watchedEvent.getType() == Event.EventType.None && null ==  watchedEvent.getPath()){
//                  countDownLatch.countDown();
              }else  if (watchedEvent.getType() == Event.EventType.NodeDataChanged){
                  try {
                      System.out.println(String.format("配置修改，新值为: %s",new String(zooKeeper.getData(watchedEvent.getPath(),true,stat))));
                  } catch ( KeeperException | InterruptedException e ) {
                      e.printStackTrace();
                  }
              }
          }
    }
}
