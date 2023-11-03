package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "m_filter_d", schema = "public")
public class FilterDetailEntity implements Serializable{
	private static final long serialVersionUID = 8686714449302828736L;
	
	@EmbeddedId
	private FilterDetailEntityPK id;
	private String operand;
	private String value;
	private String action;
	private String description;
	private String field;
	public FilterDetailEntityPK getId() {
		return id;
	}
	public void setId(FilterDetailEntityPK id) {
		this.id = id;
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
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
}
