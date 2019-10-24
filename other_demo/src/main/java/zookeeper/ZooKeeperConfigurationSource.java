package zookeeper;

import com.google.common.base.Charsets;
import com.netflix.config.WatchedUpdateListener;
import com.netflix.config.WatchedUpdateResult;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.utils.ZKPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-08-26
 */
public class ZooKeeperConfigurationSource implements WatchedConfigurationSource, Closeable {
    private static Logger logger = LoggerFactory.getLogger(ZooKeeperConfigurationSource.class);
    private final CuratorFramework client;
    private final String configRootPath;
    private final PathChildrenCache pathChildrenCache;

    private final Charset charset = Charsets.UTF_8;

    private List<WatchedUpdateListener> listenerList = new CopyOnWriteArrayList<>();

    public ZooKeeperConfigurationSource(CuratorFramework client, String configRootPath) {
        this.client = client;
        this.configRootPath = configRootPath;
        this.pathChildrenCache = new PathChildrenCache(client, configRootPath, true);
    }

    public void start() throws Exception {
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                PathChildrenCacheEvent.Type type = event.getType();
                ChildData data = event.getData();
                if (data != null) {
                    String path = data.getPath();
                    String key = ZKPaths.getNodeFromPath(data.getPath());
                    byte[] value = data.getData();
                    String stringValue = new String(value, charset);
                    logger.debug("received update to pathName [{}], eventType [{}]", path, type);
                    logger.debug("key [{}],and value [{}]", key, stringValue);
                    Map<String, Object> added = null;
                    Map<String, Object> changed = null;
                    Map<String, Object> deleted = null;
                    switch (type) {
                        case CHILD_ADDED:
                            added = new HashMap<>(1);
                            added.put(key, stringValue);
                            break;
                        case CHILD_UPDATED:
                            changed = new HashMap<>(1);
                            changed.put(key, stringValue);
                            break;
                        case CHILD_REMOVED:
                            deleted = new HashMap<>(1);
                            deleted.put(key, stringValue);
                        default:
                            logger.info("其他操作类型");
                            break;
                    }
                    WatchedUpdateResult result = WatchedUpdateResult.createIncremental(added, changed, deleted);
                    fireEvent(result);

                }

            }
        });
        pathChildrenCache.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
    }

    private void fireEvent(WatchedUpdateResult result) {
        for (WatchedUpdateListener watchedUpdateListener : listenerList) {
            watchedUpdateListener.updateConfiguration(result);
        }
    }

    private String removeRootPath(String path) {
        return path.replace(configRootPath + "/", "");
    }


    /**
     * Closes this stream and releases any system resources associated
     * with it. If the stream is already closed then invoking this
     * method has no effect.
     *
     * <p> As noted in {@link AutoCloseable#close()}, cases where the
     * close may fail require careful attention. It is strongly advised
     * to relinquish the underlying resources and to internally
     * <em>mark</em> the {@code Closeable} as closed, prior to throwing
     * the {@code IOException}.
     *
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void close() throws IOException {

    }

    @Override
    public void addUpdateListenter(WatchedUpdateListener watchedUpdateListener) {
        if (watchedUpdateListener != null) {
            listenerList.add(watchedUpdateListener);
        }

    }

    @Override
    public void removeListenter(WatchedUpdateListener watchedUpdateListener) {
        if (watchedUpdateListener != null) {
            listenerList.remove(watchedUpdateListener);
        }

    }

    @Override
    public Map<String, Object> getCurrmentData() throws Exception {
        logger.debug("getCurrendData() retrieving current data.");
        List<ChildData> childDataList = pathChildrenCache.getCurrentData();
        HashMap<String, Object> all = new HashMap<>(childDataList.size());
        for (ChildData childData : childDataList) {
            String path = childData.getPath();
            String key = removeRootPath(path);
            byte[] value = childData.getData();
            all.put(key, new String(value, charset));
        }
        return all;
    }
}
