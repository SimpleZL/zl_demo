package mybaties.namespace;

import com.sohu.smc.moment.dto.dao.model.NewsTvInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-12-26
 */
@Mapper
public interface NewsTvInfoMapper {
    @Select("select * from  news_tv_info where id = #{id}")
    NewsTvInfo findByVid(@Param("id") int id);
}
