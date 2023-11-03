package com.ikkat.los.response;

public class Response<T> {
	private String service;
	private String message;
    private T data;
    private T validation;
    public T getValidation() {
		return validation;
	}
	public void setValidation(T validation) {
		this.validation = validation;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
