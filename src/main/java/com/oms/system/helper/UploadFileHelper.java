package com.oms.system.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.oms.system.repository.AdoptionRepository;
import com.oms.system.repository.UserRepository;

@Component
public class UploadFileHelper {
	
	
	
	public boolean uploadFile(MultipartFile file ,String path) {
	
	
		
		boolean status = false;
		try {
			
			
//			InputStream is =  file.getInputStream();
//			byte data[] = new byte[is.available()];
//			
//			is.read(data);
//			
//			
//			//write
//			
//			FileOutputStream fos = new FileOutputStream(uploadDir + File.separator + file.getOriginalFilename() );
//			
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
			
			
			Files.copy(file.getInputStream(), 
					Paths.get(path + File.separator + file.toString()),
					StandardCopyOption.REPLACE_EXISTING );
			//Files.copy(file.getInputStream(), 
//					Paths.get(proofOfResidance + File.separator + Residance.getOriginalFilename()),
//					StandardCopyOption.REPLACE_EXISTING );
			System.out.println("=========================================================================");
			status = true;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
		
		
	}
}
