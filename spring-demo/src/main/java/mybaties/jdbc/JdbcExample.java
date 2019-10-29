package mybaties.jdbc;

import mybaties.bean.People;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-28
 */
public class JdbcExample {
    private Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/zl_demo?serverTimezone=GMT&autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String pwd = "123456";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pwd);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return connection;
    }

    public People getUser(int id) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select  * from p where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            People people = new People();
            while (resultSet.next()) {
                people.setId(resultSet.getInt("id"));
                people.setUserName(resultSet.getString("name"));
                people.setM(resultSet.getString("m_m"));
//                people.setSex(resultSet.getString("sex"));
            }
            return people;
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        JdbcExample jdbcExample = new JdbcExample();
        People user = jdbcExample.getUser(1);
        System.out.println();
    }
}
