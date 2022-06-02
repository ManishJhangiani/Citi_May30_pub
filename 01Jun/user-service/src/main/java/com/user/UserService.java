package com.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	void createUser(UserVO user) {
		userRepository.save(user);
	}
	
	List<UserVO> getUsers() {
		
		return userRepository.findAll();
	}
}
