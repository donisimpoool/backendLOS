package com.ikkat.los.user.mapper;

import com.ikkat.los.user.entity.UserListData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetListAllUser implements RowMapper<UserListData>{
	private String schemaSql;
	
	public GetListAllUser() {
		// TODO Auto-generated constructor stub
		final StringBuilder sqlBuilder = new StringBuilder(400);
		sqlBuilder.append("* from m_user_apps mua ");
		
		this.schemaSql = sqlBuilder.toString();
	}

	@Override
	public UserListData mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserListData data = new UserListData();
		final long id = rs.getLong("id");
		final String nama = rs.getString("name");
		final String isapproval = rs.getString("isapproval");
		final boolean isactive = rs.getBoolean("isactive");
		
		data.setId(id);
		data.setNama(nama);
		data.setIsapproval(isapproval);
		data.setIsactive(isactive);
		return data;
	}
	
	public String schema() {
		return this.schemaSql;
	}

}
