package com.oms.system.entity;


public class DonationFromFrontEnd {

	String donationType;
	Payment payment;
	
	
	 public DonationFromFrontEnd() {
		// TODO Auto-generated constructor stub
	}
	 
	 
	
	
	public DonationFromFrontEnd(String donationType, Payment payment) {
		super();
		this.donationType = donationType;
		this.payment = payment;
	}




	public String getDonationType() {
		return donationType;
	}




	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}




	public Payment getPayment() {
		return payment;
	}




	public void setPayment(Payment payment) {
		this.payment = payment;
	}




	@Override
	public String toString() {
		return "DonationFromFrontEnd [donationType=" + donationType + ", payment=" + payment + "]";
	}
	
}
