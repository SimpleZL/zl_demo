package mybaties.cache;

import org.apache.ibatis.cache.Cache;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 通过此接口自定义实现缓存，可以接入第三方的缓存组件
 * 如redis
 * 在cache中手动配置，并可通过配置文件传入参数
 * <cache type="Mycache" ></cache>
 * @author: liangzhang212928
 * @Date: 2019-10-31
 */
public class Mycache implements Cache {
    /**
     * @return The identifier of this cache
     */
    @Override
    public String getId() {
        return null;
    }

    /**
     * @param key   Can be any object but usually it is a {@link CacheKey}
     * @param value The result of a select.
     */
    @Override
    public void putObject(Object key, Object value) {

    }

    /**
     * @param key The key
     * @return The object stored in the cache.
     */
    @Override
    public Object getObject(Object key) {
        return null;
    }

    /**
     * As of 3.3.0 this method is only called during a rollback
     * for any previous value that was missing in the cache.
     * This lets any blocking cache to release the lock that
     * may have previously put on the key.
     * A blocking cache puts a lock when a value is null
     * and releases it when the value is back again.
     * This way other threads will wait for the value to be
     * available instead of hitting the database.
     *
     * @param key The key
     * @return Not used
     */
    @Override
    public Object removeObject(Object key) {
        return null;
    }

    /**
     * Clears this cache instance.
     */
    @Override
    public void clear() {

    }

    /**
     * Optional. This method is not called by the core.
     *
     * @return The number of elements stored in the cache (not its capacity).
     */
    @Override
    public int getSize() {
        return 0;
    }
}
