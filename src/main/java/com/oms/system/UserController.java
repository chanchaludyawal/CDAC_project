package com.oms.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oms.system.entity.ResponseResult;
import com.oms.system.entity.User;
import com.oms.system.service.UserService;


@CrossOrigin(origins = "*")
@RestController

@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	UserService service;
	
	// register user
	@PostMapping("/registration")
	public ResponseResult registerUser(@RequestBody User user) {
		System.out.println("user register "+user.toString());
		return service.registerUser(user);
		  
	}
	
	//login user
	@PostMapping("/login")
	public ResponseResult loginUser(@RequestBody User user){
		
		System.out.println(service.login(user));
		
		return service.login(user);
		
	}
	
	
	//get all user
	@GetMapping("/")
	public ResponseResult getAllUser(){
		
		return service.getAllUser();
		
	}
	
	// get user by Id
	@GetMapping("/{id}")
	public ResponseResult getUserById(@PathVariable("id") int id ) {
		
		return service.getUserById(id);
		
		
	}
	
	// update User
	@PutMapping("/")
	public ResponseResult updateUser(@RequestBody User user ){
		
		return service.updateUser(user);
		
	}
	
	

	
	
	
	
}
