package com.akhm.dao.model;

import lombok.Data;

@Data
public class UserTl {
	private Integer userId;
	private String firstName;
	private String lastName;
	private String password;
	private String mobileNumber;
	private String status;

}
