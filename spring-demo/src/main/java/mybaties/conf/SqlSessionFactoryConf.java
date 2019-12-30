//package mybaties.conf;
//
//import org.apache.ibatis.io.Resources;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.InputStreamResource;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// *
// * @author: liangzhang212928
// * @Date: 2019-11-04
// */
//@Configuration
//public class SqlSessionFactoryConf {
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactoryBean sqlSessionFactory(DataSource hikariDataSource) {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(hikariDataSource);
//        try {
//            sqlSessionFactoryBean.setConfigLocation(new InputStreamResource(Resources.getResourceAsStream("mybatis-config.xml")));
//        } catch ( IOException e ) {
//            e.printStackTrace();
//        }
//        return sqlSessionFactoryBean;
//    }
//
//}
