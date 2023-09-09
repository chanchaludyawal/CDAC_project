package com.oms.system;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.system.entity.DataForAdoptionFromFrontEnd;
import com.oms.system.entity.ResponseResult;
import com.oms.system.entity.User;
import com.oms.system.repository.RequestAdoptionRepository;
import com.oms.system.repository.UserRepository;
import com.oms.system.service.AdoptionService;

@CrossOrigin(origins = "*")
@RestController
public class AdoptionController {

	@Autowired
	AdoptionService adoptionService;
	
	@Autowired
	RequestAdoptionRepository requestAdoptionRepository;
	
	@Autowired
	UserRepository repository;
	
	
	
	
	@GetMapping("/getAllAdopter")
	public ResponseResult getAllAdopter(){
		
		try {
			
			return adoptionService.getAllAdopter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
		
	}
	
	@PostMapping("/request-for-adoption")
	public ResponseResult addAdoption(@RequestBody DataForAdoptionFromFrontEnd adoptionFromFrontEnd){
		
		return adoptionService.rquestForAdoption(adoptionFromFrontEnd);
	}
	
	
	@GetMapping("/requestedUser")
	public ResponseResult getRequestAdopters(){
		
		
		
		return ResponseResult.onSuccess(requestAdoptionRepository.findAll());
	}
	
	
	@GetMapping("/adoption-status/{userId}")
	public ResponseResult adoptionStatus(@PathVariable int userId){
		
		Optional<User> optional=  repository.findById(userId);
		try {
			if(optional.isPresent()) {
					
					if(requestAdoptionRepository.findByUser(optional.get())== null) {
						
					}
					return ResponseResult.onSuccess(requestAdoptionRepository.findByUser(optional.get()));
				}
				else {
					return ResponseResult.onError("there is not request");
				}
			}
			
			
		 catch (Exception e) {
			return ResponseResult.onError(""+ e);
		}
		
		
	}
	
	
	
	
}
