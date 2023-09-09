package com.oms.system.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.oms.system.entity.Adopter;
import com.oms.system.entity.Adoption;
import com.oms.system.entity.Child;
import com.oms.system.entity.DataForAdoptionFromFrontEnd;
import com.oms.system.entity.RequestAdoption;
import com.oms.system.entity.ResponseResult;
import com.oms.system.entity.User;
import com.oms.system.helper.UploadFileHelper;
import com.oms.system.repository.AdoptionRepository;
import com.oms.system.repository.ChildRepository;
import com.oms.system.repository.RequestAdoptionRepository;
import com.oms.system.repository.UserRepository;

@Service
public class AdoptionService {
	
	@Autowired
	AdoptionRepository adoptionRepository;
	
	@Autowired
	RequestAdoptionRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ChildRepository childRepository;
	
	@Autowired
	UploadFileHelper fileHelper ;
	
	private final String proofOfResidance= "/home/chanchal/Documents/Project/spring_boot_server/SpringBootServer/src/main/resources/static/proofOfMarrige";
	private final String famliyPhoto = "/home/chanchal/Documents/Project/spring_boot_server/SpringBootServer/src/main/resources/static/famliy_image";

	private final String proofOfMarige = "/home/chanchal/Documents/Project/spring_boot_server/SpringBootServer/src/main/resources/static/proofOfMarrige";
	
	//
	public ResponseResult rquestForAdoption(DataForAdoptionFromFrontEnd adoptionFromFrontEnd){
	
		
		try {
			
			ResponseResult responseResult = null;
			
			RequestAdoption requestAdoption =  new RequestAdoption();
			Child child = childRepository.findById(adoptionFromFrontEnd.getChild_id()).get();
			
			User user = userRepository.findById(adoptionFromFrontEnd.getUser_id()).get();
			
			Optional<RequestAdoption> optional =   repository.findByUser(user);
			if(optional.isPresent()) {
				responseResult = ResponseResult.onSuccess("requested");
				
			}
			else if(optional.isEmpty()) {
				
				requestAdoption.setChild(child);
				requestAdoption.setUser(user);
				requestAdoption.setStatus("Pending");
				
				 repository.save(requestAdoption);
				 responseResult = ResponseResult.onSuccess(repository.save(requestAdoption));
				 
			}
			
			
			
			
			return responseResult;
			
		} catch (Exception e) {
			return ResponseResult.onError("There is error "  + e);
		}
	}
	
	public ResponseResult getAllAdopter()
	{
		
		ResponseResult result = ResponseResult.onSuccess(adoptionRepository.findAll());
		
		return result;
		
		
	}
	
	
	public ResponseResult fileUpload(User user,Adopter adopter ,MultipartFile marriageCertificate ,MultipartFile residenceCertificate, MultipartFile image ){
		try {
				
				user.setIncome(adopter.getIncome());
				user.setOccupation(adopter.getOccupation());
				user.setHealth(adopter.getHealth());
				user.setAgency(adopter.getAgency());
				user.setProofOfMarrige(marriageCertificate.toString());
				user.setProofOfResidance(residenceCertificate.toString());
				user.setFamliyPhoto(image.toString());
				userRepository.save(user);
				boolean res =  fileHelper.uploadFile(image,famliyPhoto);
				fileHelper.uploadFile(marriageCertificate,proofOfMarige);
				fileHelper.uploadFile(residenceCertificate,proofOfResidance);
				System.out.println(res);
				return ResponseResult.onSuccess(user);
			}catch(Exception e) {
				return ResponseResult.onError("Error");
			}
		
	}
	
//	void addrequestForAdoption(){
//		adoptionRepository.
//		
//	}

}
