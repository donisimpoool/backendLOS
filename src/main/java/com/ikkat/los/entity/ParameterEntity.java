package com.ikkat.los.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_paramater", schema = "public")
public class ParameterEntity {
	@Id
	private String id;
	private String paramater;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParamater() {
		return paramater;
	}
	public void setParamater(String paramater) {
		this.paramater = paramater;
	}
	
}
