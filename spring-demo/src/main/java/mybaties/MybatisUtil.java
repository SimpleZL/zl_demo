package mybaties;

import mybaties.bean.People;
import mybaties.bean.Student;
import mybaties.bean.Subject;
import mybaties.bean.SubjectCore;
import mybaties.enums.Sex;
import mybaties.namespace.RoleMapper;
import mybaties.namespace.StudentMapper;
import mybaties.namespace.SubjectMapper;
import mybaties.namespace.SubjectScoreMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static Logger logger = LoggerFactory.getLogger(MybatisUtil.class);
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



//        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//        Student student = studentMapper.findById(41);
//        logger.info(student.getStudentCard().toString());

        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        HashMap<String, Integer> map = new HashMap<>(2);
        map.put("id", 4);
        map.put("sex", Sex.FEMALE.getId());
        logger.info("同一个session 第一次查询！");
        People user = roleMapper.getUserByMap(4, 2);
        sqlSession.commit();



//        People people = new People();
//        people.setUserName("李四");
//        people.setSex(Sex.FEMALE);
//        people.setM("李四加油");
//        roleMapper.insertUser(people);
//        System.out.println("更新指定数据");
//        roleMapper.updateUser(1,"redPig");
//        System.out.println("删除指定数据");
//        roleMapper.deleteUser(4);


    }
}
