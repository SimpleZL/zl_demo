package mybaties.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-29
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes({String.class})
public class MyStringTypeHandler implements TypeHandler<String> {
    private Logger logger = LoggerFactory.getLogger(MyStringTypeHandler.class);

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        logger.info("使用的自定义typeHandler");
        ps.setString(i, parameter);
    }

    /**
     * @param rs
     * @param columnName Colunm name, when configuration <code>useColumnLabel</code> is <code>false</code>
     */
    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        logger.info("使用的自定义typeHandler->ResultSet rs, String columnName");
        return rs.getString(columnName);
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        logger.info("使用的自定义typeHandler->ResultSet rs");
        return rs.getString(columnIndex);
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        logger.info("使用的自定义typeHandler->CallableStatement");
        return cs.getString(columnIndex);
    }
}
