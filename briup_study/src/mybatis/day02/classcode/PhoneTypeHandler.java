package mybatis.day02.classcode;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * phone的自定义类型处理器
 * @author cheney
 *
 */
public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber>{

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return new PhoneNumber(rs.getString(columnName));
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int i)
			throws SQLException {
		return new PhoneNumber(rs.getString(i));
	}

	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int i)
			throws SQLException {
		return null;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			PhoneNumber phone, JdbcType jt) throws SQLException {
		ps.setString(i, phone.getAsString());
	}
	
}
