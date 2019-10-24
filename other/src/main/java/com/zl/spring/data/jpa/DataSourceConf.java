package com.zl.spring.data.jpa;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 配置数据源
 *
 * @author: liangzhang212928
 * @Date: 2019-07-10
 */
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class DataSourceConf {
    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        String jdbcUrl = String.format("jdbc:mysql://%s:%s/%s?serverTimezone=UTC&zeroDateTimeBehavior=convertToNull&autoReconnect=true&useUnicode=true&characterEncoding=UTF-8"
                , "localhost", 3306, "zl_demo");
        hikariDataSource.setJdbcUrl(jdbcUrl);
        hikariDataSource.setUsername("root");
        hikariDataSource.setPassword("123456");
        hikariDataSource.setMinimumIdle(20);
        hikariDataSource.setMaximumPoolSize(50);
//        hikariDataSource.setMetricRegistry();
//        hikariDataSource.setHealthCheckRegistry();
        hikariDataSource.setIdleTimeout(60);
        hikariDataSource.setPoolName("zl_demo");
        return hikariDataSource;
    }

    /**
     * jpa 厂商配置器
     *
     * @return
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(false);
        return hibernateJpaVendorAdapter;
    }

    /**
     * 配置实体管理类工厂
     *
     * @param hikariDataSource
     * @param jpaVendorAdapter
     * @return
     */
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(HikariDataSource hikariDataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(hikariDataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactoryBean.setPackagesToScan("com.zl.spring.data.jpa.model");
        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
