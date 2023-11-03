package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "application_business", schema = "public")
public class ApplicationBusinessEntity implements Serializable{
	@Id
	private String applicationid;
	private String companyname;
	private String companyaddress;
	private String provinceid;
	private String division;
	private String position;
	private int duration;
	private int numberofemployees;
	private String businessline;
	private String idregencies;
	private String iddistrict;
	
	@OneToOne()
    @JoinColumn(name="provinceid",insertable = false, updatable = false)
    private ProvinceEntity province;
	
	@OneToOne()
    @JoinColumn(name="idregencies",insertable = false, updatable = false)
    private RegenciesEntity regencies;
	
	@OneToOne()
    @JoinColumn(name="iddistrict",insertable = false, updatable = false)
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
	public String getIdregencies() {
		return idregencies;
	}
	public void setIdregencies(String idregencies) {
		this.idregencies = idregencies;
	}
	public String getIddistrict() {
		return iddistrict;
	}
	public void setIddistrict(String iddistrict) {
		this.iddistrict = iddistrict;
	}
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCompanyaddress() {
		return companyaddress;
	}
	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getNumberofemployees() {
		return numberofemployees;
	}
	public void setNumberofemployees(int numberofemployees) {
		this.numberofemployees = numberofemployees;
	}
	public String getBusinessline() {
		return businessline;
	}
	public void setBusinessline(String businessline) {
		this.businessline = businessline;
	}
	@Override
	public String toString() {
		return "ApplicationBusinessEntity [applicationid=" + applicationid + ", companyname=" + companyname
				+ ", companyaddress=" + companyaddress + ", provinceid=" + provinceid + ", division=" + division
				+ ", position=" + position + ", duration=" + duration + ", numberofemployees=" + numberofemployees
				+ ", businessline=" + businessline + "]";
	}
	
}
