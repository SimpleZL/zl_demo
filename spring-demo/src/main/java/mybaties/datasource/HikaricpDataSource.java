package mybaties.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-29
 */
@Component(value = "hikariDataSource")
public class HikaricpDataSource implements DataSourceFactory {
    private Properties properties;
    private Logger logger = LoggerFactory.getLogger(HikaricpDataSource.class);

    @Override
    public void setProperties(Properties props) {
        this.properties = props;
    }

    @Override
    public DataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(properties.getProperty("url"));
        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));
        //可不配置
        dataSource.setDriverClassName(properties.getProperty("driver"));
        dataSource.setIdleTimeout(2000);
        //等待获取连接时间-默认30s，超过配置阈值抛异常
        dataSource.setConnectionTimeout(500);
        dataSource.setPoolName("zl_demo_dbPool");
        logger.info("采用hikaricpDataSource");
        return dataSource;
    }
}
