package com.ikkat.los.shared;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class Response {
private static final Logger LOGGER = LoggerFactory.getLogger(Response.class);
	
	private boolean success;
	private String message;
	private String messagecode;
	private int httpcode;
	private List<ValidationDataMessage> validations;
	private Object data;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessagecode() {
		return messagecode;
	}
	public void setMessagecode(String messagecode) {
		this.messagecode = messagecode;
	}
	public int getHttpcode() {
		return httpcode;
	}
	public void setHttpcode(int httpcode) {
		this.httpcode = httpcode;
	}
	public List<ValidationDataMessage> getValidations() {
		return validations;
	}
	public void setValidations(List<ValidationDataMessage> validations) {
		this.validations = validations;
	}
}
