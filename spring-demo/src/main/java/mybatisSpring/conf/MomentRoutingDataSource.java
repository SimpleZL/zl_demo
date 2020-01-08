package mybatisSpring.conf;

import mybatisSpring.annotation.DataSourceType;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-12-31
 */

public class MomentRoutingDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<DataSourceType> dataSourceHolder = new ThreadLocal<>();

    public static void setDataSource(DataSourceType dataSourceType) {
        dataSourceHolder.set(dataSourceType);
    }

    public static DataSourceType getDataSource() {
        return dataSourceHolder.get();
    }

    public static void clear() {
        dataSourceHolder.remove();
    }

    /**
     * Determine the current lookup key. This will typically be
     * implemented to check a thread-bound transaction context.
     * <p>Allows for arbitrary keys. The returned key needs
     * to match the stored lookup key type, as resolved by the
     * {@link #resolveSpecifiedLookupKey} method.
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }


}
