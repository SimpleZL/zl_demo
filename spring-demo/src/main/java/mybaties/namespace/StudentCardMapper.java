package mybaties.namespace;

import mybaties.bean.StudentCard;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 学生证
 * @author: liangzhang212928
 * @Date: 2019-10-30
 */
@Mapper
public interface StudentCardMapper {
    StudentCard findByNumber(int studentId);
}
