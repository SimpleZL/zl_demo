package mybaties.namespace;

import mybaties.bean.People;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-28
 */
public interface RoleMapper {
    public People getUser(int id);
}
