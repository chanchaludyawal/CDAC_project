package com.oms.system.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity

@Table(name="child")
public class Child {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "child_id")
	int childId;
	String name;
	String age;
	String gender;
	String enjoys;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	String birthdate;
	String health;
	String childImage;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "uid")
	User user;
	
	
	
	public Child() {
		
	}
	
	



	public Child(int childId, String name, String age, String gender, String enjoys, String birthdate, String health,
			String childImage, User user) {
		super();
		this.childId = childId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.enjoys = enjoys;
		this.birthdate = birthdate;
		this.health = health;
		this.childImage = childImage;
		this.user = user;
	}





	public int getChildId() {
		return childId;
	}



	public void setChildId(int childId) {
		this.childId = childId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getEnjoys() {
		return enjoys;
	}



	public void setEnjoys(String enjoys) {
		this.enjoys = enjoys;
	}



	public String getBirthdate() {
		return birthdate;
	}



	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}



	public String getHealth() {
		return health;
	}



	public void setHealth(String health) {
		this.health = health;
	}



	public String getChildImage() {
		return childImage;
	}



	public void setChildImage(String childImage) {
		this.childImage = childImage;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}





	@Override
	public String toString() {
		return "Child [childId=" + childId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", enjoys="
				+ enjoys + ", birthdate=" + birthdate + ", health=" + health + ", childImage=" + childImage + ", user="
				+ user + "]";
	}

	


	

	

}
