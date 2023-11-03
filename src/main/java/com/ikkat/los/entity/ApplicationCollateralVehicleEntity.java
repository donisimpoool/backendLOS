package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application_collateral_vehicle", schema = "public")
public class ApplicationCollateralVehicleEntity implements Serializable{
	@Id
	private String applicationid;
	private String typevehicle;
	private String brand;
	private String typetransmision;
	private String year;
	private String mileage;
	private String model;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String getTypevehicle() {
		return typevehicle;
	}
	public void setTypevehicle(String typevehicle) {
		this.typevehicle = typevehicle;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getTypetransmision() {
		return typetransmision;
	}
	public void setTypetransmision(String typetransmision) {
		this.typetransmision = typetransmision;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	
	
}
