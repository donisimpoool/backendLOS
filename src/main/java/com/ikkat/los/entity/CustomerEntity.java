package com.ikkat.los.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ikkat.los.jsonmodel.ApplicationPersonelJson;
import com.ikkat.los.service.RunningNumberService;
import com.ikkat.los.utils.Utils;

@Entity
@Table(name = "m_customer")
public class CustomerEntity implements Serializable {
	@Id
	private String customerid;
	private String name;
	private String mobilephone;
	private String landlinephone;
	private String placeofbirth;
	private Timestamp dateofbirth;
	private String gender;
	private String typeid;
	private String idnumber;
	private String education;
	private String maritalstatus;
	private String email;
	private String cif_id;
	
	@Transient
	private long dateofbirthlong;
	
	public long getDateofbirthlong() {
		long date = 0L;
		if(this.dateofbirth != null) {
			date = getDateofbirth().getTime();
		}
		return date;
	}
	public void setDateofbirthlong(long dateofbirthlong) {
		this.dateofbirthlong = dateofbirthlong;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
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
	public Timestamp getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Timestamp dateofbirth) {
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
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
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
	public String getCif_id() {
		return cif_id;
	}
	public void setCif_id(String cif_id) {
		this.cif_id = cif_id;
	}

	public CustomerEntity setEntity(ApplicationPersonelJson json,RunningNumberService service) {
		CustomerEntity entity = new CustomerEntity();
		long number = Utils.GetRunningNumber(service, "customer");
		String custid = Utils.RunningNumber(number);
		
		entity.setCustomerid(custid);
		entity.setCif_id(json.getCfiid());
		entity.setDateofbirth(new Timestamp(json.getDateofbirth()));
		entity.setEducation(json.getEducation());
		entity.setEmail(json.getEmail());
		entity.setGender(json.getGender());
		entity.setIdnumber(json.getIdnumber());
		entity.setLandlinephone(json.getLandlinephone());
		entity.setMaritalstatus(json.getMaritalstatus());
		entity.setMobilephone(json.getMobilephone());
		entity.setName(json.getFullname());
		entity.setPlaceofbirth(json.getPlaceofbirth());
		entity.setTypeid(json.getIdtype());
		
		return entity;
	}

}
