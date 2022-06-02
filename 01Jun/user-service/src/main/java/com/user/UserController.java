package com.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseController{

	@Autowired
	UserService userService;
	
	@PostMapping("addUser")
	@ResponseStatus(code = HttpStatus.CREATED)
	void createUser(@Valid @RequestBody UserVO user) {
		
		userService.createUser(user);
		System.out.println(user.getId()+" -> " + user.getName()+" -> "+user.getAge());
		
	}
	
	@GetMapping("listUsers")
	List<UserVO> getUsers(){
		return userService.getUsers();
	}
}
