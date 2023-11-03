package com.ikkat.los.entity;

import java.io.Serializable;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application_score")
public class ApplicationScoreEntity implements Serializable{
	@Id
	private String applicationid;
	private int propertypossession;
	private int numberofdependant;
	private int gender;
	private int location;
	private int liveownershipstatus;
	private int vehicleowner;
	private int maritalstatus;
	private int companysize;
	private int creditcardowner;
	private int debtincomeratio;
	private int industrysector;
	private int education;
	private int incometype;
	private int age;
	private int durationwork;
	private int jobtittle;
	private int position;

	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public int getPropertypossession() {
		return propertypossession;
	}
	public void setPropertypossession(int propertypossession) {
		this.propertypossession = propertypossession;
	}
	public int getNumberofdependant() {
		return numberofdependant;
	}
	public void setNumberofdependant(int numberofdependant) {
		this.numberofdependant = numberofdependant;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getLiveownershipstatus() {
		return liveownershipstatus;
	}
	public void setLiveownershipstatus(int liveownershipstatus) {
		this.liveownershipstatus = liveownershipstatus;
	}
	public int getVehicleowner() {
		return vehicleowner;
	}
	public void setVehicleowner(int vehicleowner) {
		this.vehicleowner = vehicleowner;
	}
	public int getMaritalstatus() {
		return maritalstatus;
	}
	public void setMaritalstatus(int maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	public int getCompanysize() {
		return companysize;
	}
	public void setCompanysize(int companysize) {
		this.companysize = companysize;
	}
	public int getCreditcardowner() {
		return creditcardowner;
	}
	public void setCreditcardowner(int creditcardowner) {
		this.creditcardowner = creditcardowner;
	}
	public int getDebtincomeratio() {
		return debtincomeratio;
	}
	public void setDebtincomeratio(int debtincomeratio) {
		this.debtincomeratio = debtincomeratio;
	}
	public int getIndustrysector() {
		return industrysector;
	}
	public void setIndustrysector(int industrysector) {
		this.industrysector = industrysector;
	}
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	public int getIncometype() {
		return incometype;
	}
	public void setIncometype(int incometype) {
		this.incometype = incometype;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getDurationwork() {
		return durationwork;
	}
	public void setDurationwork(int durationwork) {
		this.durationwork = durationwork;
	}
	public int getJobtittle() {
		return jobtittle;
	}
	public void setJobtittle(int jobtittle) {
		this.jobtittle = jobtittle;
	}
	
	public ApplicationScoreEntity SetEntity(HashMap<String, Double> mapscore,String appID) {
		ApplicationScoreEntity entity = new ApplicationScoreEntity();
		entity.setApplicationid(appID);
		entity.setPropertypossession(mapscore.get("propertypossession").intValue());
		entity.setNumberofdependant(mapscore.get("numberofdependant").intValue());
		entity.setGender(mapscore.get("gender").intValue());
		entity.setLocation(mapscore.get("location").intValue());
		entity.setLiveownershipstatus(mapscore.get("liveownershipstatus").intValue());
		entity.setVehicleowner(mapscore.get("vehicleowner").intValue());
		entity.setMaritalstatus(mapscore.get("maritalstatus").intValue());
		entity.setCompanysize(mapscore.get("companysize").intValue());
		entity.setCreditcardowner(mapscore.get("creditcardowner").intValue());
		entity.setDebtincomeratio(mapscore.get("debtincomeratio").intValue());
		entity.setIndustrysector(mapscore.get("industrysector").intValue());
		entity.setEducation(mapscore.get("education").intValue());
		entity.setIncometype(mapscore.get("incometype").intValue());
		entity.setAge(mapscore.get("age").intValue());
		entity.setDurationwork(mapscore.get("durationwork").intValue());
		entity.setJobtittle(mapscore.get("jobtittle").intValue());
		entity.setPosition(mapscore.get("position").intValue());
		return entity;
	}
	
}
