package com.akhm.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.akhm.dao.model.UserTl;

public class UserRowMapper implements RowMapper<UserTl> {

	@Override
	public UserTl mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserTl userTl=new UserTl();
		userTl.setUserId(rs.getInt("user_id"));
		userTl.setFirstName(rs.getString("first_name"));
		userTl.setLastName(rs.getString("last_name"));
		userTl.setPassword(rs.getString("password"));
		userTl.setMobileNumber(rs.getString("mobile_number"));
		userTl.setStatus(rs.getString("status"));
		
		return userTl;
	}

}
