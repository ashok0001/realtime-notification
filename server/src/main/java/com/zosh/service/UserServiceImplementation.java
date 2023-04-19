package com.zosh.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zosh.exception.UserException;
import com.zosh.modal.User;
import com.zosh.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	UserRepository userRepository;
	
	public UserServiceImplementation(UserRepository userRepository) {
		this.userRepository=userRepository;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public User createUser(User user) {
		
		User createdUser=userRepository.save(user);
		
		return createdUser;
	}

	@Override
	public User findUserById(Integer userId) throws UserException {
		Optional<User> user=userRepository.findById(userId);
		
		if(user.isPresent()) {
			return user.get();
		}
		throw new UserException(null);
	}

}
