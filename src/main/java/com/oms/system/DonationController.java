package com.oms.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.system.entity.Donation;
import com.oms.system.entity.DonationFromFrontEnd;
import com.oms.system.entity.ResponseResult;
import com.oms.system.entity.User;
import com.oms.system.repository.DonationRepository;
import com.oms.system.repository.PaymentRepository;
import com.oms.system.repository.UserRepository;

import jakarta.transaction.Transactional;


@CrossOrigin(origins = "*")
@RestController
public class DonationController {

	@Autowired
	DonationRepository donationRepo;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	
	// do Donation
	
	
	@PostMapping("/donation/{id}")
	@Transactional
	public ResponseResult doDonation(@RequestBody DonationFromFrontEnd donationFromFrontEnd,@PathVariable int id){
		ResponseResult result;
		
		try {

			Donation donation = new Donation();
			
			User user  = userRepository.findById(id).get();
		
			donationFromFrontEnd.getDonationType();
			;
			donation.setUser(user);
			
			System.out.println(donationFromFrontEnd.getDonationType());
			System.out.println(donationFromFrontEnd);
			donation.setDonationType(donationFromFrontEnd.getDonationType());
			donation.setPayment(donationFromFrontEnd.getPayment());
			donation.setPayment(paymentRepository.save(donationFromFrontEnd.getPayment()));
			
			donationRepo.save(donation);
			
			
			
			result = ResponseResult.onSuccess(donation);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			
			result = ResponseResult.onError(" not inserted..." + e);
			return result;
			
		}
		
		
	}
	
	
	//Get All Donation
	@GetMapping("/donation/{id}")
	public ResponseResult getAllDonationById(@PathVariable int id){
		ResponseResult result = null;
		try {
			
			User user = userRepository.findById(id).get();
			
			result = ResponseResult.onSuccess(donationRepo.findByUser(user));
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			result = ResponseResult.onError("not geting error");
			return result;
		}
	}
	
	@GetMapping("/donation")
	public ResponseResult  getAllDonation(){
		
		ResponseResult result = null;
		try {
			result = ResponseResult.onSuccess(donationRepo.findAll());
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			result = ResponseResult.onError("not geting error");
			return result;
		}
		
		
	}
	
	
	@DeleteMapping("/donation/{id}")
	public ResponseResult deleteDonation(@RequestBody int id) {
		
		ResponseResult result = null;
		try {
			
			int val = donationRepo.deleteByDonationId(id);
			
			result = ResponseResult.onSuccess(val);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			result = ResponseResult.onError("geting error");
			return result;
		}
		
	}
}
