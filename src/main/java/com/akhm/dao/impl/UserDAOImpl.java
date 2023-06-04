package com.akhm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.akhm.dao.UserDAO;
import com.akhm.dao.mapper.UserRowMapper;
import com.akhm.dao.model.UserTl;
@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer insertUserTl(UserTl userTl) {
		Integer numberOfRowsInserted=0;
		String sql="insert into user_tl(first_name,last_name,password,mobile_number,status)values('"+userTl.getFirstName()+"','"+userTl.getLastName()+"','"+userTl.getPassword()+"','"+userTl.getMobileNumber()+"','"+userTl.getStatus()+"')";
		numberOfRowsInserted=jdbcTemplate.update(sql);
		return numberOfRowsInserted;
	}

	@Override
	public UserTl getUser(Integer userId) {
		String sql="select user_id,first_name,last_name,password,mobile_number,status from user_tl where user_id=?";
		UserTl user=jdbcTemplate.queryForObject(sql, new Object[] {userId},new RowMapper<UserTl>() {

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
		});

		return user;
	}

	@Override
	public void updateUser(UserTl userTl) {
		String sql="update user_tl set first_name?,last_name?,password?,mobile_number?,status? where user_id=?";
		jdbcTemplate.update(sql,userTl.getFirstName(),userTl.getLastName(),userTl.getPassword(),
					userTl.getMobileNumber(),userTl.getStatus(),userTl.getUserId());
		
		
	}

	@Override
	public List<UserTl> getUsers() {
		
		return jdbcTemplate.query("select user_id,first_name,last_name,password,mobile_number,status from user_tl", new UserRowMapper());
	}

	@Override
	public void deleteUser(Integer userId) {
		String sql="delete from USER_TL where user_id";
		jdbcTemplate.update(sql,userId);
		
		
	}

}
