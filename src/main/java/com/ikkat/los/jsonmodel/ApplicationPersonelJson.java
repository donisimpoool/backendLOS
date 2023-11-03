package com.ikkat.los.jsonmodel;

public class ApplicationPersonelJson {
	private String fullname;
	private String mobilephone;
	private String landlinephone;
	private String placeofbirth;
	private long dateofbirth;
	private String gender;
	private String idtype;
	private String idnumber;
	private String education;
	private String maritalstatus;
	private String email;
	private int numberofdependant;
	private String cfiid;
	private String customerid;
	private String religionid;
	private String taxnumber;
	
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
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCfiid() {
		return cfiid;
	}
	public void setCfiid(String cfiid) {
		this.cfiid = cfiid;
	}
	public int getNumberofdependant() {
		return numberofdependant;
	}
	public void setNumberofdependant(int numberofdependant) {
		this.numberofdependant = numberofdependant;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
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
	public long getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(long dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIdtype() {
		return idtype;
	}
	public void setIdtype(String idtype) {
		this.idtype = idtype;
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
	@Override
	public String toString() {
		return "ApplicationPersonelJson [fullname=" + fullname + ", mobilephone=" + mobilephone + ", landlinephone="
				+ landlinephone + ", placeofbirth=" + placeofbirth + ", dateofbirth=" + dateofbirth + ", gender="
				+ gender + ", idtype=" + idtype + ", idnumber=" + idnumber + ", education=" + education
				+ ", maritalstatus=" + maritalstatus + ", email=" + email + "]";
	}
	
}
