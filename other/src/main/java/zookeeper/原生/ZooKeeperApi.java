package zookeeper.原生;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-02-25
 */
public class ZooKeeperApi {
    public static ZooKeeper getZookeeperConn(String address) throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper(address, 5000, watchedEvent -> System.out.println("type:" + watchedEvent.getType() + "keepstat:" + watchedEvent.getState().getIntValue()));
        System.out.println("创建连接成功"+zooKeeper.getSessionId());
        return zooKeeper;
    }

    public static void zKCreateOp() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zookeeper = getZookeeperConn("127.0.0.1:2181");
        if (zookeeper != null) {
            /**
             * 创建临时节点
             * Zookeeper ZooDefs.Ids
             * OPEN_ACL_UNSAFE  : 完全开放的ACL，任何连接的客户端都可以操作该属性znode
             * CREATOR_ALL_ACL : 只有创建者才有ACL权限
             * READ_ACL_UNSAFE：只能读取ACL
             */
//            System.out.println(zookeeper.create("/mydata/dev1", "zl-100".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL));
            //重复创建节点(KeeperException$NodeExistsException: KeeperErrorCode = NodeExists for /mydata/dev1)
//            System.out.println(zookeeper.create("/mydata/dev1","zl-100".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL));
            //路径不存在的节点
//            System.out.println(zookeeper.create("/father", "new node".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL));
            System.out.println(zookeeper.create("/lock/seq_node", "zl-sequential".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL));
            //重复节点
            System.out.println(zookeeper.create("/lock/seq_node", "zl-sequential".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL));

            List<String> children = zookeeper.getChildren("/lock", false);
            children.stream().forEach(System.out::println);
        }
    }

    public static void getOp() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zookeeper = getZookeeperConn("127.0.0.1:2181");
        //获取子节点
        List<String> children = zookeeper.getChildren("/", false);
        System.out.println("所有的字节点：");
        children.stream().forEach(System.out::println);
        //获取指定节点的权限信息
        List<ACL> acl = zookeeper.getACL("/test", new Stat());
        System.out.println("节点权限信息：");
        acl.stream().forEach(System.out::println);
        //获取节点数据
        System.out.println("节点数据;");
        byte[] data = zookeeper.getData("/test", false, new Stat());
        System.out.println(new String(data));
        //获取客户端状态
        ZooKeeper.States state = zookeeper.getState();
        System.out.println("zk stats :" + state);
    }

    public static void setOp() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zookeeper = getZookeeperConn("127.0.0.1:2181");
        zookeeper.setData("/test","mydata-set".getBytes(),-1);
        System.out.println(zookeeper.getData("/test",false,new Stat()));


    }


    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        zKCreateOp();
//         getOp();
//        setOp();
//        System.in.read();
    }


    public class IVoidCallBack implements  AsyncCallback.VoidCallback{

        /**
         * Process the result of the asynchronous call.
         * <p/>
         * On success, rc is
         * {@link KeeperException.Code#OK}.
         * <p/>
         * On failure, rc is set to the corresponding failure code in
         * {@link KeeperException}.
         * <ul>
         * <li>
         * {@link KeeperException.Code#NONODE}
         * - The node on given path doesn't exist for some API calls.
         * </li>
         * <li>
         * {@link KeeperException.Code#BADVERSION}
         * - The given version doesn't match the node's version
         * for some API calls.
         * </li>
         * <li>
         * {@link KeeperException.Code#NOTEMPTY}
         * - the node has children and some API calls cannnot succeed,
         * e.g. {@link
         * ZooKeeper#delete(String, int,
         * VoidCallback, Object)}.
         * </li>
         * </ul>
         *  @param rc   The return code or the result of the call.
         *
         * @param path The path that we passed to asynchronous calls.
         * @param ctx  Whatever context object that we passed to
         */
        @Override
        public void processResult(int rc, String path, Object ctx) {

        }
    }
}
