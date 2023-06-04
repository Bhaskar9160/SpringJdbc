package com.akhm.dao;

import java.util.List;

import com.akhm.dao.model.UserTl;

public interface UserDAO {
	public Integer insertUserTl(UserTl userTl);
	public UserTl getUser(Integer userId);
	public  void updateUser(UserTl userTl);
	public List<UserTl> getUsers();
	public void deleteUser(Integer userId);

}
