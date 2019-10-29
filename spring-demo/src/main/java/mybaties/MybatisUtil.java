package mybaties;

import mybaties.bean.People;
import mybaties.enums.Sex;
import mybaties.namespace.RoleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-28
 */
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSessionFactory getSessionFactory() {
        if (sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";
            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
                return sqlSessionFactory;
            } catch ( IOException e ) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        SqlSessionFactory sessionFactory = getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        //获取映射
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        HashMap<String, Integer> map = new HashMap<>(2);
        map.put("id", 4);
        map.put("sex", Sex.FEMALE.getId());
        People user = roleMapper.getUserByMap(4, 2);
        System.out.println(user.getUserName());
        sqlSession.commit();
    }
}
