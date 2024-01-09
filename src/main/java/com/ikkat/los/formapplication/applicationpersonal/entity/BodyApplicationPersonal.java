package com.ikkat.los.formapplication.applicationpersonal.entity;

import java.sql.Date;

public class BodyApplicationPersonal {
    private String customerid;
    private String cfiid;

    private String names;
        private String mobilephone;
    private String landlinephone;
    private String placeofbirth;
    private Long dateofbirthtime;
    private String gender;
    private String typeid;
    private String education;
    private String maritalstatus;
    private String email;
    private String idnumber;
    private int numberofdependant;
    private String religionid;
    private String taxnumber;

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

    public Long getDateofbirthtime() {
        return dateofbirthtime;
    }

    public void setDateofbirthtime(Long dateofbirthtime) {
        this.dateofbirthtime = dateofbirthtime;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
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

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public int getNumberofdependant() {
        return numberofdependant;
    }

    public void setNumberofdependant(int numberofdependant) {
        this.numberofdependant = numberofdependant;
    }

    public String getReligionid() {
        return religionid;
    }

    public void setReligionid(String religionid) {
        this.religionid = religionid;
    }

    public String getTaxnumber() {
        return taxnumber;
    }

    public void setTaxnumber(String taxnumber) {
        this.taxnumber = taxnumber;
    }
}
