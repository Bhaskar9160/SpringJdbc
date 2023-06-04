package com.akhm.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JDBCConfiguration {
	@Value("${jdbc.driverClass}")
	private String driverClassName;
	@Value("${jdbc.db.url}")
	private String url;
	@Value("${jdbc.db.userName}")
	private String userName;
	@Value("${jdbc.db.password}")
	private String password;
	
	public DataSource getDataSource() {
		DriverManagerDataSource dataSorce=new DriverManagerDataSource();
		dataSorce.setDriverClassName(driverClassName);
		dataSorce.setUrl(url);
		dataSorce.setUsername(userName);
		dataSorce.setPassword(password);
		
		return dataSorce;
	}
	public JdbcTemplate getJDBCTemplate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		return jdbcTemplate;
	}
	

}
