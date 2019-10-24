package zookeeper;

import com.netflix.config.WatchedUpdateListener;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-08-26
 */
public interface WatchedConfigurationSource {
    void addUpdateListenter(WatchedUpdateListener watchedUpdateListener);

    void removeListenter(WatchedUpdateListener watchedUpdateListener);

    Map<String, Object> getCurrmentData() throws Exception;
}
