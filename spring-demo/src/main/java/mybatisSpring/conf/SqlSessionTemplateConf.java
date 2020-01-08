package mybatisSpring.conf;

import com.zaxxer.hikari.HikariDataSource;
import mybatisSpring.annotation.DataSourceType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-12-31
 */
@Configuration
@MapperScan(basePackages = "mybatisSpring.mapper"  )
@ComponentScan(basePackages = "mybatisSpring")
@EnableAspectJAutoProxy
public class SqlSessionTemplateConf {

    /**
     * 初始化dataSource
     *
     * @return
     * @throws Exception
     */
    private HikariDataSource getDataSource(String dbname) throws Exception {

        HikariDataSource dataSource = new HikariDataSource();
        String jdbcUrl = String.format("jdbc:mysql://%s:%s/%s?zeroDateTimeBehavior=CONVERT_TO_NULL&autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai"
                , "devmysql.mrd.sohuno.com", 3306, "mpaper_cms2");
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername("portal");
        dataSource.setPassword("portal@sohu");
        dataSource.setMinimumIdle(10);
        dataSource.setMaximumPoolSize(20);
        //等待获取连接时间-默认30s，超过配置阈值抛异常
        dataSource.setConnectionTimeout(500);
        dataSource.setPoolName(dbname);
        return dataSource;
    }


    @Bean
    public DataSource momentRoutingDataSource() throws Exception {
        MomentRoutingDataSource momentRoutingDataSource = new MomentRoutingDataSource();
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceType.CMS_RO, getDataSource("cms_ro"));
        targetDataSource.put(DataSourceType.CMS_RW, getDataSource("cms_rw"));
        momentRoutingDataSource.setTargetDataSources(targetDataSource);
//        momentRoutingDataSource.setDefaultTargetDataSource(getDataSource("cms_ro"));
        return momentRoutingDataSource;
    }

    @Bean("momentSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(DataSource momentRoutingDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(momentRoutingDataSource);
        return new SqlSessionTemplate(factoryBean.getObject());
    }

}
