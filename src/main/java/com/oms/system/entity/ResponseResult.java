package com.oms.system.entity;

public class ResponseResult {
	
	private String status;
	private Object data;
	private String message;
	
	public ResponseResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	  

	public ResponseResult(String status, Object data, String message) 
	{
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "ResponseResult [status=" + status + ", data=" + data + ", message=" + message + "]";
	}
	
	
	public static ResponseResult onSuccess(Object data) {
		
		ResponseResult result = new ResponseResult();
		result.status = "success";
		result.setData(data);
		result.setMessage("success Code : 200");
		return result;
	}
	public static ResponseResult onError(String msg) {
		
		ResponseResult result = new ResponseResult();

		result.setStatus("Error");
		result.setMessage(msg);
		return result;
	}
	
	
	
	

}
