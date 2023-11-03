package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_filter", schema = "public")
public class FilterEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long filterid;
	private String operand;
	private String value;
	private String action;
	private String description;
	private String field;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public long getFilterid() {
		return filterid;
	}
	public void setFilterid(long filterid) {
		this.filterid = filterid;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
