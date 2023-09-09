package com.oms.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.system.entity.ResponseResult;
import com.oms.system.entity.User;
import com.oms.system.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public ResponseResult registerUser(User user){
		
		ResponseResult result = null;
		Optional <User> u =repo.findByEmail(user.getEmail());
		if(u.isEmpty()) {
			user.setRole("user");
			User dbUser = repo.save(user);
			result = ResponseResult.onSuccess(dbUser);
				 return result;
		}
		
		result = ResponseResult.onError("already Register..");
		return result;
	
	}
	
	public ResponseResult login(User user) {
		
		Optional<User> u =repo.findByEmailAndPassword(user.getEmail(),user.getPassword());
	
		ResponseResult result = null;
		if(u.isPresent()) {
			
			result = ResponseResult.onSuccess( u.get());
			System.out.println(result);
			return result;
		}
		System.out.println(result);
		result = ResponseResult.onError("not valid user");
		return result;
		
				
	}
	
	public ResponseResult getAllUser(){
		ResponseResult result = null;
		try {
			 result = ResponseResult.onSuccess(repo.findAll());
			 return result;
		} catch (Exception e) {
			result = ResponseResult.onError("Error ...");
		}
		
		return result;
		
	}
	
	public ResponseResult getUserById(int id) {
		Optional <User> user = repo.findById(id);
		
		
		ResponseResult result = null;
		try {
			 result = ResponseResult.onSuccess(user.get());
			 return result;
		} catch (Exception e) {
			result = ResponseResult.onError("Error ...");
		}
		
		return result;
		
		
		
		
	}

	public ResponseResult updateUser(User user) {
		Optional<User> u= repo.findById(user.getUserId());
		ResponseResult result = null;
		
		try {
		if(u.isPresent()) {
			u.get().setFirstName(user.getFirstName());
			u.get().setLastName(user.getLastName());
			
			
		}
		
		User dbuser = repo.save(u.get());
		result = ResponseResult.onSuccess(dbuser);
		return result;
		}
		catch(Exception exception ){
			result = ResponseResult.onError("Error ...");
		}
		return result;
	}
	
	
	
	
	
	

}
