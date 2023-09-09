package com.oms.system.entity;

public class DataForAdoptionFromFrontEnd {

	int user_id;
	int child_id;
	String status;
	public DataForAdoptionFromFrontEnd() {
		// TODO Auto-generated constructor stub
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getChild_id() {
		return child_id;
	}
	public void setChild_id(int child_id) {
		this.child_id = child_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "DataForAdoptionFromFrontEnd [user_id=" + user_id + ", child_id=" + child_id + ", status=" + status
				+ "]";
	}
	 
	
}
