package com.henry.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class ExampleTypeHandler extends BaseTypeHandler<String>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
			throws SQLException {
		System.out.println("setNonNullParameter");
		ps.setString(i, parameter);
	}
	
	/**
	 * select的时候处理
	 */
	@Override
	public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
		System.out.println("getNullableResultByColumnName");
		String str = rs.getString(columnName);
		if(str.equals("henry")) {
			return "yes henry";
		}
			return "no henry";
	}

	@Override
	public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		System.out.println("getNullableResultByColumnIndex");
		return rs.getString(columnIndex);
	}

	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		System.out.println("getNullableResult");
		return cs.getString(columnIndex);
	}
	
}
