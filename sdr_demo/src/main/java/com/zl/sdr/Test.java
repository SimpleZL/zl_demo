package com.zl.sdr;

import java.sql.*;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-05-13
 */
public class Test {
    static String url = "jdbc:hive2://dsrv2.heracles.sohuno.com:10000/msmc;principal=hive/dsrv2.heracles.sohuno.com@HERACLES.SOHUNO.COM";
    static String urlDefault = "jdbc:hive2://dsrv2.heracles.sohuno.com:10000/default;principal=hive/dsrv2.heracles.sohuno.com@HERACLES.SOHUNO.COM";
    static String sql = "select  * from op_follow_feed limit 2";
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url);
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
    }
}
