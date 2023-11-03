package com.ikkat.los.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ikkat.los.utils.Utils;

@Entity
@Table(name = "application_personal")
public class applicationPersonelEntity implements Serializable{
	@Id
	@Column(name="applicationid")
	private String applicationID;
	@Column(name="name")
	private String name;
	@Column(name="mobilephone")
	private String mobilephone;
	@Column(name="landlinephone")
	private String landlinephone;
	@Column(name="placeofbirth")
	private String placeofbirth;
	@Column(name="dateofbirth")
	private ZonedDateTime dateofbirth;
	@Column(name="gender")
	private String gender;
	@Column(name="typeid")
	private String typeid;
	@Column(name="education")
	private String education;
	@Column(name="maritalstatus")
	private String maritalstatus;
	@Column(name="email")
	private String email;
	private String idnumber;
	private int numberofdependant;
	private String religionid;
	private String taxnumber;
	
	@Transient
	private String datebirth;
	
	public String getTaxnumber() {
		return taxnumber;
	}
	public void setTaxnumber(String taxnumber) {
		this.taxnumber = taxnumber;
	}
	public String getReligionid() {
		return religionid;
	}
	public void setReligionid(String religionid) {
		this.religionid = religionid;
	}
	public String getDatebirth() {
		String temp = "";
		if(this.dateofbirth != null) {
			String hour = this.dateofbirth.getHour()+"";
			String minute = this.dateofbirth.getMinute()+"";
			if(this.dateofbirth.getHour() < 10) {
				hour = "0"+this.dateofbirth.getHour();
			}
			if(this.dateofbirth.getMinute() < 10) {
				minute = "0"+this.dateofbirth.getMinute();
			}
			temp = this.dateofbirth.getDayOfMonth() +"-"+Utils.namabulan3(this.dateofbirth.getMonthValue())+"-"+this.dateofbirth.getYear();
		}
		return temp;
	}
	public void setDatebirth(String datebirth) {
		this.datebirth = datebirth;
	}
	public int getNumberofdependant() {
		return numberofdependant;
	}
	public void setNumberofdependant(int numberofdependant) {
		this.numberofdependant = numberofdependant;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public String getLandlinephone() {
		return landlinephone;
	}
	public void setLandlinephone(String landlinephone) {
		this.landlinephone = landlinephone;
	}
	public String getPlaceofbirth() {
		return placeofbirth;
	}
	public void setPlaceofbirth(String placeofbirth) {
		this.placeofbirth = placeofbirth;
	}
	public ZonedDateTime getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(ZonedDateTime dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMaritalstatus() {
		return maritalstatus;
	}
	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
