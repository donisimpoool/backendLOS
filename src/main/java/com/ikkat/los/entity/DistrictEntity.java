package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_district", schema = "public")
public class DistrictEntity implements Serializable {
	private static final long serialVersionUID = 8686714449302828736L;

	@Id
	private String iddistrict;
	private String idregencies;
	private String namedistrict;
	public String getIddistrict() {
		return iddistrict;
	}
	public void setIddistrict(String iddistrict) {
		this.iddistrict = iddistrict;
	}
	public String getIdregencies() {
		return idregencies;
	}
	public void setIdregencies(String idregencies) {
		this.idregencies = idregencies;
	}
	public String getNamedistrict() {
		return namedistrict;
	}
	public void setNamedistrict(String namedistrict) {
		this.namedistrict = namedistrict;
	}
}
