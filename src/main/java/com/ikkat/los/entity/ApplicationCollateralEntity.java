package com.ikkat.los.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application_collateral", schema = "public")
public class ApplicationCollateralEntity {
	@Id
	private String applicationid;
	private String collateral;
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String getCollateral() {
		return collateral;
	}
	public void setCollateral(String collateral) {
		this.collateral = collateral;
	}
	
	
}
