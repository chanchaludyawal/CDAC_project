package com.oms.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "donation")
public class Donation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "donation_id")
	int donationId;

	@Column(name = "donation_type")
	String donationType;
	
	@OneToOne
	Payment payment;
	
	
	
	@ManyToOne
	@JoinColumn(name = "uid")
	User user;
	
	public Donation() {
		
	}
	
	

	public Donation(int donationId, String donationType, Payment payment, User user) {
		super();
		this.donationId = donationId;
		this.donationType = donationType;
		this.payment = payment;
		this.user = user;
	}


	

	public int getDonationId() {
		return donationId;
	}



	public void setDonationId(int donationId) {
		this.donationId = donationId;
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



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}


	

	@Override
	public String toString() {
		return "Donation [donationId=" + donationId + ", donationType=" + donationType + ", payment=" + payment
				+ ", user=" + user + "]";
	}
	
	

	
	
	
	
	
}
