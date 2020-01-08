package mybatisSpring;

import mybaties.bean.NewsTvInfo;
import mybatisSpring.conf.SqlSessionTemplateConf;
import mybatisSpring.dao.NewsTvInfoDao;
import mybatisSpring.mapper.cms.NewsTvInfoMapper;
import mybatisSpring.mapper.mpaper.ActivityMapper;
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
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SqlSessionTemplateConf.class);
        NewsTvInfoDao dao = context.getBean(NewsTvInfoDao.class);
        NewsTvInfo newsTvInfo = dao.getNewsTvInfo(9102910);
        System.out.println(newsTvInfo.getBigPic());

        NewsTvInfo newsTvInfoRw = dao.getNewsTvInfoRw(9102910);
        System.out.println(newsTvInfoRw.getBigPic());

    }
}
