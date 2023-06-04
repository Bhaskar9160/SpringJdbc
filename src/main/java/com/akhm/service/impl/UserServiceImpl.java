package com.akhm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.dao.UserDAO;
import com.akhm.dao.model.UserTl;

import com.akhm.service.UserService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;

	@Override
	public Integer insertUserTl(UserTl userTl) {
		log.info("{}-UserServiceImpl insertUser()method  user details");
		return userDAO.insertUserTl(userTl);
					
	}

	@Override
	public UserTl getUser(Integer userId) {
		log.info("{}-UserServiceImpl getUser()method  user details");
		return userDAO.getUser(userId);
	}

	@Override
	public void updateUser(UserTl userTl) {
		log.info("{}-UserServiceImpl updateUser()method  user details");
		userDAO.updateUser(userTl);
		
	}

	@Override
	public List<UserTl> getUsers(){
		log.info("{}-UserServiceImpl getUsers()method  user details");
		return userDAO.getUsers();
	}

	@Override
	public void deleteUser(Integer userId) {
		log.info("{}-UserServiceImpl deleteUser()method  user details");
		userDAO.deleteUser(userId);
		
	}

}
