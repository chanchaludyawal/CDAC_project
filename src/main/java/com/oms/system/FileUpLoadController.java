package com.oms.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.oms.system.entity.Adopter;
import com.oms.system.entity.Adoption;
import com.oms.system.entity.ResponseResult;
import com.oms.system.entity.User;
import com.oms.system.repository.UserRepository;
import com.oms.system.service.AdoptionService;

@CrossOrigin(origins = "*" )
@RestController

public class FileUpLoadController {
	
	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	AdoptionService adoptionService;
	
	@PostMapping("/adoption-request/{id}")
	public ResponseResult uploadFile( @RequestBody MultipartFile proofOfResidance  ,Adopter adopter, MultipartFile proofOfMarrige ,MultipartFile famliyPhoto , @PathVariable int id){
		
		System.out.println(famliyPhoto);
		System.out.println(proofOfResidance);
		System.out.println();
		
		System.out.println(famliyPhoto.getOriginalFilename());
		
		
		System.out.println(adopter.toString());
		
		
		System.out.println(adopter.getIncome());
		System.out.println(adopter.getOccupation());
		
		User user = userRepository.findById(id).get();
		
//		Adoption adoption = new Adoption();
//		adoption.setUser(user);
//		adoption.setChild();
//		
//		adoptionService.rquestForAdoption();
		
		return adoptionService.fileUpload(user, adopter, proofOfResidance, proofOfMarrige, famliyPhoto);
		
		
		
	}

}
