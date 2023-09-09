package com.oms.system.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Adoption {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	
	@ManyToOne
	@JoinColumn(name = "uid")
	User user;
	
	String status;
	@OneToOne
	@JoinColumn(name = "cid")
	Child child;
	
	@Column(name = "date_of_adoption")
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	Date dateOfAdoption;

	
	public Adoption(){
		
	}

	

	public Adoption(int id, User user, String status, Child child, Date dateOfAdoption) {
		super();
		this.id = id;
		this.user = user;
		this.status = status;
		this.child = child;
		this.dateOfAdoption = dateOfAdoption;
	}


	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Child getChild() {
		return child;
	}



	public void setChild(Child child) {
		this.child = child;
	}



	public Date getDateOfAdoption() {
		return dateOfAdoption;
	}



	public void setDateOfAdoption(Date dateOfAdoption) {
		this.dateOfAdoption = dateOfAdoption;
	}



	@Override
	public String toString() {
		return "Adoption [id=" + id + ", user=" + user + ", status=" + status + ", child=" + child + ", dateOfAdoption="
				+ dateOfAdoption + "]";
	}
	
	
	
	
	

}
