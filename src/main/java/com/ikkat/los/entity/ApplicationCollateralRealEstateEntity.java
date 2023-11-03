package com.ikkat.los.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "application_collateral_real_estate", schema = "public")
public class ApplicationCollateralRealEstateEntity {
	
	@Id
	private String applicationid;
	private String typerealestate;
	private String condition;
	private int year;
	private int rooms;
	private String address;
	private String provinceid;
	private String regenciesid;
	private String districtid;
	private String size;
	private String proofofownership;
	@OneToOne()
    @JoinColumn(name="provinceid",insertable = false, updatable = false)
    private ProvinceEntity province;
	
	@OneToOne()
    @JoinColumn(name="regenciesid",insertable = false, updatable = false)
    private RegenciesEntity regencies;
	
	@OneToOne()
    @JoinColumn(name="districtid",insertable = false, updatable = false)
    private DistrictEntity district;
	
	public ProvinceEntity getProvince() {
		return province;
	}
	public void setProvince(ProvinceEntity province) {
		this.province = province;
	}
	public RegenciesEntity getRegencies() {
		return regencies;
	}
	public void setRegencies(RegenciesEntity regencies) {
		this.regencies = regencies;
	}
	public DistrictEntity getDistrict() {
		return district;
	}
	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String getTyperealestate() {
		return typerealestate;
	}
	public void setTyperealestate(String typerealestate) {
		this.typerealestate = typerealestate;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getRegenciesid() {
		return regenciesid;
	}
	public void setRegenciesid(String regenciesid) {
		this.regenciesid = regenciesid;
	}
	public String getDistrictid() {
		return districtid;
	}
	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getProofofownership() {
		return proofofownership;
	}
	public void setProofofownership(String proofofownership) {
		this.proofofownership = proofofownership;
	}
	
}
