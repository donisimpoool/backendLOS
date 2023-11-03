package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_province", schema = "public")
public class ProvinceEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8686714449302828736L;

	@Id
	@Column(name = "location_code")
	private String locationCode;
	
	@Column(name = "location_name")
	private String locationName;
	private String id_simpool;

	public String getId_simpool() {
		return id_simpool;
	}

	public void setId_simpool(String id_simpool) {
		this.id_simpool = id_simpool;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
}
