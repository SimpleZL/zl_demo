package mybaties;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * Created by skychen on 2017/7/26.
 */
@Configuration
@ComponentScan(basePackages = "mybaties")
@MapperScan(basePackages = "mybaties.namespace" )
public class SpringJdbcConf {

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
        dataSource.setIdleTimeout(2000);
        //等待获取连接时间-默认30s，超过配置阈值抛异常
        dataSource.setConnectionTimeout(500);
        dataSource.setPoolName(dbname);
        return dataSource;
    }


    @Bean
    public HikariDataSource cmsRODataSource() throws Exception {

        return getDataSource("cms");
    }

    @Bean
    public HikariDataSource cmsRwDataSource() throws Exception {
        return getDataSource("cms");

    }

    @Bean("cmsRoSqlSessionTemplate")
    public SqlSessionTemplate cmsRoSqlSessionTemplate(HikariDataSource cmsRODataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(cmsRODataSource);
        return new SqlSessionTemplate(factoryBean.getObject());
    }

    @Bean("cmsRwSqlSessionTemplate")
    public SqlSessionTemplate cmsRWSqlSessionTemplate(HikariDataSource cmsRwDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(cmsRwDataSource);
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
