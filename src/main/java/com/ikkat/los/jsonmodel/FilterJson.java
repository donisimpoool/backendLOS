package com.ikkat.los.jsonmodel;

import com.ikkat.los.entity.FilterEntity;

public class FilterJson {
	private long id;
	private String operand;
	private String value;
	private String action;
	private String desccription;
	private String field;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public FilterEntity setFilterEntity() {
		FilterEntity entity = new FilterEntity();
//		entity.setFilterid(0);
		entity.setField(this.field);
		entity.setAction(this.action);
		entity.setDescription(this.desccription);
		entity.setOperand(this.operand);
		entity.setValue(this.value);
		return entity;
	}
	public String getOperand() {
		return operand;
	}
	public void setOperand(String operand) {
		this.operand = operand;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDesccription() {
		return desccription;
	}
	public void setDesccription(String desccription) {
		this.desccription = desccription;
	}
}
