package com.akhm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akhm.dao.model.UserTl;
import com.akhm.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<Integer>  insertUserTl(@RequestBody UserTl userTl) {
		log.info("{}-UserController...insertUser() method Started");
		try {
			log.info("{}-UserController insertUser()method get user details");
			return new ResponseEntity<Integer>(userService.insertUserTl(userTl),HttpStatus.OK);
		} catch (Exception e) {
			log.error("{}-UserController insertUser() method error message is:"+e.getMessage());
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getuser/{userid}")
	public ResponseEntity<UserTl> getUser(@PathVariable Integer userId) {
		log.info("{}-UserController...getUser() method Started");
		try {
			log.info("{}-UserController getUser()method get user details");
			return new ResponseEntity<UserTl>(userService.getUser(userId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("In UserController getUser() method error message is:"+e.getMessage());
			return new ResponseEntity<UserTl>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/user/user")
	public ResponseEntity<Void>  updateUser(@RequestBody UserTl userTl) {
		log.info("{}-UserController...updateUser() method Started");
		 try {
			 log.info("{}-UserController updateUser()method get user details");
			userService.updateUser(userTl);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("In UserController updateUser() method error message is:"+e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/user/get")
	public ResponseEntity<List<UserTl>> getUsers(){
		log.info("{}-UserController...getUsers() method Started");
		try {
			log.info("{}-UserController getUsers()method get user details");
			return new ResponseEntity<List<UserTl>>(userService.getUsers(),HttpStatus.OK);
		} catch (Exception e) {
			log.error("In UserController getUsers() method error message is:"+e.getMessage());
			return new ResponseEntity<List<UserTl>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/user/deletuser")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
		log.info("{}-UserController...deleteUser() method Started");
		try {
			log.info("{}-UserController deleteUser()method get user details");
			userService.deleteUser(userId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("In UserController deleteUser() method error message is:"+e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
