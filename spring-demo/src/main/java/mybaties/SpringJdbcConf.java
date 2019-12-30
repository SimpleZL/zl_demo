package conf;

import com.sohu.mrd.framework.config.DataSourceConfig;
import com.sohu.mrd.framework.config.DynamicDataSourceConfigure;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * Created by skychen on 2017/7/26.
 */
@Configuration
public class SpringJdbcConf {

    /**
     * 初始化dataSource
     *
     * @param dataSourceConfig
     * @return
     * @throws Exception
     */
    private HikariDataSource getDataSource(DataSourceConfig dataSourceConfig, String dbname) throws Exception {
        if (dataSourceConfig == null) {
            throw new Exception("数据源配置不能为空！！！！");
        }
        HikariDataSource dataSource = new HikariDataSource();
        String jdbcUrl = String.format("jdbc:mysql://%s:%s/%s?zeroDateTimeBehavior=convertToNull&autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai"
                , dataSourceConfig.getAddress(), dataSourceConfig.getPort(), dataSourceConfig.getDbName());
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(dataSourceConfig.getUser());
        dataSource.setPassword(dataSourceConfig.getPassword());
        dataSource.setMinimumIdle(dataSourceConfig.getMinPoolSize());
        dataSource.setMaximumPoolSize(dataSourceConfig.getMaxPoolSize());
        dataSource.setIdleTimeout(2000);
        //等待获取连接时间-默认30s，超过配置阈值抛异常
        dataSource.setConnectionTimeout(500);
        dataSource.setPoolName(dbname);
        return dataSource;
    }

    @Bean
    public DynamicDataSourceConfigure dataSourceConfigure() {
        DynamicDataSourceConfigure configure = new DynamicDataSourceConfigure();
        configure.init();
        return configure;
    }

    @Bean
    public HikariDataSource cmsRODataSource(DynamicDataSourceConfigure configure) throws Exception {
        String key = DataSourceEnum.MaperCms2Ro.getValue();
        DataSourceConfig dataSourceConfig = configure.getDateSourceConfig(key);
        return getDataSource(dataSourceConfig, key);
    }

    @Bean
    public HikariDataSource cmsRwDataSource(DynamicDataSourceConfigure configure) throws Exception {
        String key = DataSourceEnum.MaperCms2Rw.getValue();
        DataSourceConfig dataSourceConfig = configure.getDateSourceConfig(key);
        return getDataSource(dataSourceConfig, key);

    }

    @Bean
    public SqlSessionTemplate cmsROSqlSessionTemplate(HikariDataSource cmsRODataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(cmsRODataSource);
        return new SqlSessionTemplate(factoryBean.getObject());
    }

    @Bean
    public SqlSessionTemplate cmsRWSqlSessionTemplate(HikariDataSource cmsRWDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(cmsRWDataSource);
        return new SqlSessionTemplate(factoryBean.getObject());
    }

    @Bean
    public JdbcTemplate cmsRoJdbcTemplate(HikariDataSource cmsRODataSource) {
        return new JdbcTemplate(cmsRODataSource);
    }

    @Bean
    public JdbcTemplate cmsRwJdbcTemplate(HikariDataSource cmsRwDataSource) {
        return new JdbcTemplate(cmsRwDataSource);
    }

}
