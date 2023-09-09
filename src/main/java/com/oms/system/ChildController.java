package com.oms.system;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.oms.system.entity.Child;
import com.oms.system.entity.ResponseResult;
import com.oms.system.repository.ChildRepository;
import com.oms.system.service.ChildService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/child")
public class ChildController {
	
	@Autowired 
	ChildService ser;
	
	@Autowired
	ChildRepository repo;
	
	
	
	//add Child
	@PostMapping("/add")
	public ResponseResult addChild(@RequestBody  MultipartFile file,Child child){
		
		System.out.println(child);
		
		return ser.addChild(child,file);
		
	}
	
	// get All child
	@GetMapping("/")
	public ResponseResult getAllChild(){
		return ser.getAllChild();
		
	}
	
	// get child by id
	@GetMapping("/{cid}")
	public ResponseResult getChildById(@PathVariable int cid ) {
		
	
		return 	ser.getChildByCid( cid);
		
	}
	
	@PutMapping("/{cid}")
	public Child updateChild(@RequestBody Child child ,@PathVariable int cid) {
		return ser.updateChild(child,cid);
		
	}
	
	
	// delete by id
	@DeleteMapping("/{cid}")
	public ResponseResult deleteChild(@PathVariable int cid) {
		
		System.out.println("On Delete Child");
	
	
		return ser.mydeleteChildByChildId(cid);
		
	}
	
	@GetMapping("/image/{childId}")
	public  ResponseEntity<byte[]> getImageByChildId(@PathVariable int childId) throws IOException{
		

		Optional<Child> childOptional = repo.findById(childId);
		if(childOptional.isPresent()) {
			
			try {

				String filePath = "/home/chanchal/Documents/Project/assets/images/" ;

				String fileName = childOptional.get().getChildImage();
				
				
				
				
				if(fileName != null) {
					File file = new File("/home/chanchal/Documents/Project/spring_boot_server/SpringBootServer/src/main/resources/static/ChildImage/"+fileName);
					
					
					byte[]  fileInByte = FileUtils.readFileToByteArray(file); 
					
					
					return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(fileInByte);
//					 ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(fileInByte);
				}
				else if(fileName == null){
					return ResponseEntity.status(HttpStatus.CONTINUE).body(null) ;
				
				}
				
				
				
			}
			catch(Exception exception) {
				
				return ResponseEntity.status(HttpStatus.CONTINUE).body(null) ;
			}
			
		}
		return null;		
		

		
	}
	
	
}
