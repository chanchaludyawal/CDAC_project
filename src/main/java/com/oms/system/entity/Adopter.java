package com.oms.system.entity;



public class Adopter {
	
	
	
	String income;
	String occupation;
	String health;
	String agency;
	
	
	
	Adopter(){
		
	}
	
	public Adopter(String income, String occupation, String health, String agency,
			String familyPhoto, String residanceProof, String marriageProof) {
		super();
		
		this.income = income;
		this.occupation = occupation;
		this.health = health;
		this.agency = agency;
		
		
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



	@Override
	public String toString() {
		return "Adopter [income=" + income + ", occupation=" + occupation + ", health=" + health + ", agency=" + agency
				+"]";
	}


	
	

	

	



}
