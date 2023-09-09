package com.oms.system.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "payment")
public class Payment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	int paymentId;

	String ammount;
	@Column(name = "pay_date")

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	Date paymentDate;
	@Column(name = "card_no")
	String cardNo;
	@Column(name = "cvc_no")
	String cvcNo;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "expire_date")
	
	String expireDate;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.REMOVE)
	Donation donation;
	
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}
	





	public Payment(int paymentId, String ammount, Date paymentDate, String cardNo, String cvcNo, String expireDate,
			Donation donation) {
		super();
		this.paymentId = paymentId;
		this.ammount = ammount;
		this.paymentDate = paymentDate;
		this.cardNo = cardNo;
		this.cvcNo = cvcNo;
		this.expireDate = expireDate;
		this.donation = donation;
	}






	public String getAmmount() {
		return ammount;
	}



	public void setAmmount(String ammount) {
		this.ammount = ammount;
	}



	public Date getPaymentDate() {
		return paymentDate;
	}



	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}



	public String getCardNo() {
		return cardNo;
	}



	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}



	public String getCvcNo() {
		return cvcNo;
	}



	public void setCvcNo(String cvcNo) {
		this.cvcNo = cvcNo;
	}



	public String getExpireDate() {
		return expireDate;
	}



	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	

	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public Donation getDonation() {
		return donation;
	}
	public void setDonation(Donation donation) {
		this.donation = donation;
	}
	@Override
	public String toString() {
		return "Payment [ ammount=" + ammount + ", paymentDate=" + paymentDate + ", cardNo="
				+ cardNo + ", cvcNo=" + cvcNo + ", expireDate=" + expireDate + "]";
	}
	
}
