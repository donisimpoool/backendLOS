package com.ikkat.los.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_linebusiness", schema = "public")
public class LineBusinessEntity {
	
	@Id
	private String id;
	private String name;
	private String isactive;
	private String createdby;
	private Timestamp createddate;
	private Timestamp modifieddate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Timestamp getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}
	public Timestamp getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}
}
