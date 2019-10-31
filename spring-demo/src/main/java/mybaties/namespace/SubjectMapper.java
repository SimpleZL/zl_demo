package mybaties.namespace;

import mybaties.bean.Subject;
import mybaties.bean.SubjectCore;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-30
 */
@Mapper
public interface SubjectMapper {
    Subject findById(int integer);
}
