package com.zosh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.modal.User;
import com.zosh.service.UserService;

@RestController
public class UserController {
	
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
		// TODO Auto-generated constructor stub
	}
	
	
	@PostMapping("/api/users")
	public ResponseEntity<User> createUserHandler(@RequestBody User user){
		
		User createdUser=userService.createUser(user);
		
		return new ResponseEntity<User>(createdUser,HttpStatus.ACCEPTED);
		
	}

}
