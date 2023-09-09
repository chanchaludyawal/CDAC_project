
package com.oms.system.entity;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")

public class User{
	

	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@JsonProperty("userId")
	@Column(name="user_id")
	int userId;
	
	@Column(name="first_name")
	String firstName;
	@Column(name="last_name")
	String lastName;
	@Column(unique=true,nullable = false)
	
	String email;
	String address;
	String city;
	String state;
	String country;
	String pincode;
	String mobile;
	String role;
	String password;
	
	String income;
	String occupation;
	String health;
	String agency;
	
	String proofOfMarrige;
	String proofOfResidance;
	String famliyPhoto;
	
	
	@JsonIgnore
	@OneToMany
	List<Adoption> adoption;
	@JsonIgnore
	@OneToMany
	List<Donation> donation;
	
	public User() {
		
	}

	public User(int userId, String firstName, String lastName, String email, String address, String city, String state,
			String country, String pincode, String mobile, String role, String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.mobile = mobile;
		this.role = role;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public List<Adoption> getAdoption() {
		return adoption;
	}

	public void setAdoption(List<Adoption> adoption) {
		this.adoption = adoption;
	}

	public List<Donation> getDonation() {
		return donation;
	}

	public void setDonation(List<Donation> donation) {
		this.donation = donation;
	}

	
	public String getProofOfMarrige() {
		return proofOfMarrige;
	}

	public void setProofOfMarrige(String proofOfMarrige) {
		this.proofOfMarrige = proofOfMarrige;
	}

	public String getProofOfResidance() {
		return proofOfResidance;
	}

	public void setProofOfResidance(String proofOfResidance) {
		this.proofOfResidance = proofOfResidance;
	}

	public String getFamliyPhoto() {
		return famliyPhoto;
	}

	public void setFamliyPhoto(String famliyPhoto) {
		this.famliyPhoto = famliyPhoto;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode="
				+ pincode + ", mobile=" + mobile + ", role=" + role + ", password=" + password + "]";
	}

	
	

	
	
	
	
	
	
	
}
