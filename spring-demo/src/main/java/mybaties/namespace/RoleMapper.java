package mybaties.namespace;

import mybaties.bean.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-28
 */
@Mapper
public interface RoleMapper {
    People getUser(int id);

    People getUserByMap(@Param("id") Integer id,@Param("sex") Integer sex);

    void insertUser(People people);

    int updateUser(@Param("id") Integer id,@Param("name") String name);

    int deleteUser(int id);
}
