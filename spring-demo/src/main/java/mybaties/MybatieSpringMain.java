package mybaties;

import mybaties.bean.NewsTvInfo;
import mybaties.namespace.NewsTvInfoMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-12-30
 */
public class MybatieSpringMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringJdbcConf.class);


        SqlSessionTemplate cmsROSqlSessionTemplate = (SqlSessionTemplate) context.getBean("cmsRoSqlSessionTemplate");
        NewsTvInfoMapper newsTvInfoMapper = cmsROSqlSessionTemplate.getMapper(NewsTvInfoMapper.class);
        NewsTvInfo byVid = newsTvInfoMapper.findByVid(9102910);
        System.out.println(byVid.getBigPic());
    }
}
