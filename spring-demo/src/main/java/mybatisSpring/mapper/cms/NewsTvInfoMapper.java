package mybatisSpring.mapper.cms;

import mybaties.bean.NewsTvInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-12-26
 */

public interface NewsTvInfoMapper {
    @Select("select * from  news_tv_info where id = #{id}")
    NewsTvInfo findByVid(@Param("id") int id);
}
