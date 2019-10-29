package mybaties.handler;

import mybaties.enums.Sex;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

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
public class SexEnumTypeHandler implements TypeHandler<Sex> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Sex parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getId());
    }

    /**
     * @param rs
     * @param columnName Colunm name, when configuration <code>useColumnLabel</code> is <code>false</code>
     */
    @Override
    public Sex getResult(ResultSet rs, String columnName) throws SQLException {
        int id = rs.getInt(columnName);
        return Sex.getSex(id);
    }

    @Override
    public Sex getResult(ResultSet rs, int columnIndex) throws SQLException {
        int id = rs.getInt(columnIndex);
        return Sex.getSex(id);
    }

    @Override
    public Sex getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int id = cs.getInt(columnIndex);
        return Sex.getSex(id);
    }
}
