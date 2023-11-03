package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application_family", schema = "public")
public class ApplicationFamilyEntity implements Serializable{
	@Id
	private String applicationid;
	private String contactemergency;
	private String addressemergencycontact;
	private String mobileemergency;
	private String mothername;
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String getContactemergency() {
		return contactemergency;
	}
	public void setContactemergency(String contactemergency) {
		this.contactemergency = contactemergency;
	}
	public String getAddressemergencycontact() {
		return addressemergencycontact;
	}
	public void setAddressemergencycontact(String addressemergencycontact) {
		this.addressemergencycontact = addressemergencycontact;
	}
	public String getMobileemergency() {
		return mobileemergency;
	}
	public void setMobileemergency(String mobileemergency) {
		this.mobileemergency = mobileemergency;
	}
}
