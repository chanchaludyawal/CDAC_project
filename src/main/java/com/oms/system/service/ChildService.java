package com.oms.system.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.oms.system.entity.Child;
import com.oms.system.entity.RequestAdoption;
import com.oms.system.entity.ResponseResult;
import com.oms.system.helper.UploadFileHelper;
import com.oms.system.repository.ChildRepository;
import com.oms.system.repository.RequestAdoptionRepository;

import jakarta.transaction.Transactional;

@Service
public class ChildService {

	@Autowired
	ChildRepository repo;
	@Autowired
	RequestAdoptionRepository repository;
	
	@Autowired
	UploadFileHelper fileHelper;
	
	public final String childImagePath = "/home/chanchal/Documents/Project/spring_boot_server/SpringBootServer/src/main/resources/static/ChildImage";

	public ResponseResult addChild(Child child , MultipartFile file) {
		
		
		
		ResponseResult result = null;
		try {
			
			if(file != null) {
				System.out.println(file.getOriginalFilename());
				
				
				fileHelper.uploadFile(file,childImagePath);
				child.setChildImage(file.toString());
				Child dbChild = repo.save(child);
				result = ResponseResult.onSuccess(dbChild);
				return result;
			}
			else {
				
				
				Child dbChild = repo.save(child);
				result = ResponseResult.onSuccess(dbChild);
				return result;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			result = ResponseResult.onError("eroore on adding child" + e);
			return result;
		}
				
		
	}


	public ResponseResult getAllChild() {
		
		return ResponseResult.onSuccess(repo.findAll());
	}


	public ResponseResult getChildByCid(int cid) {
		
		
		return ResponseResult.onSuccess(repo.findById(cid).get());
		
	}
	
	
	public Child updateChild(Child child, int cid) {
		
		Optional<Child> c  = repo.findById(cid);
		c.get().setBirthdate(child.getBirthdate());
		c.get().setName(child.getName());
		c.get().setAge(child.getAge());
		c.get().setHealth(child.getHealth());
		
		return repo.save(c.get());
		
	}



	@Transactional
	public ResponseResult mydeleteChildByChildId(int childId) {
		
	//	System.out.println("work1");
		
		Optional<Child> optionalChild =repo.findById(childId);
		//System.out.println("work2");
		if(optionalChild.isPresent()) {
		//	System.out.println("work3");
			Child child = optionalChild.get();
			System.out.println(repository.findByChild(child).isPresent());
			if(repository.findByChild(optionalChild.get()).isPresent() ) {
				return ResponseResult.onError("requested For Adoption");
			}
			return ResponseResult.onSuccess(repo.deleteByChildId(childId));
		}
		
		return ResponseResult.onError("error");
		
		
		
	}
	
	
	

}
