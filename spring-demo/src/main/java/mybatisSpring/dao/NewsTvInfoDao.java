package mybatisSpring.dao;

import mybaties.bean.NewsTvInfo;
import mybatisSpring.annotation.DataSource;
import mybatisSpring.annotation.DataSourceType;
import mybatisSpring.mapper.cms.NewsTvInfoMapper;
import mybatisSpring.mapper.mpaper.ActivityMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-01-02
 */
@Service
@DataSource(type = DataSourceType.CMS_RO)
public class NewsTvInfoDao {
    @Autowired
    private SqlSessionTemplate momentSqlSessionTemplate;

    public NewsTvInfo getNewsTvInfo(int id) {
        NewsTvInfoMapper mapper = momentSqlSessionTemplate.getMapper(NewsTvInfoMapper.class);
        return mapper.findByVid(id);
    }

    @DataSource(type = DataSourceType.CMS_RW)
    public NewsTvInfo getNewsTvInfoRw(int id) {
        ActivityMapper mapper = momentSqlSessionTemplate.getMapper(ActivityMapper.class);
        return mapper.findByVid(id);
    }
}
