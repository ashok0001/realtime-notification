package com.zosh.service;

import com.zosh.exception.UserException;
import com.zosh.modal.User;

public interface UserService {
	
	public User createUser(User user);
	
	public User findUserById(Integer userId) throws UserException;

}
