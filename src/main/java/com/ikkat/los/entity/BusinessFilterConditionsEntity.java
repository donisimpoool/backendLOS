package com.ikkat.los.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "filter_conditions")
public class BusinessFilterConditionsEntity implements Serializable{
	@Id
	private long id;
	private String field;
	private String operand;
	private String value;
	private String action;
	private String description;
	private ZonedDateTime createddate;
	private ZonedDateTime updatedate;
	private String userid;
	public ZonedDateTime getCreateddate() {
		return createddate;
	}
	public void setCreateddate(ZonedDateTime createddate) {
		this.createddate = createddate;
	}
	public ZonedDateTime getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(ZonedDateTime updatedate) {
		this.updatedate = updatedate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
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
