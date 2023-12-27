package com.ikkat.los.formapplication.applicationfamily.entity;

public class ApplicationFamilyData {
    private Long id;
    private Long idapplication;
    private String contactemergency;
    private String addressemergencycontact;
    private String mobileemergency;
    private String mothername;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdapplication() {
        return idapplication;
    }

    public void setIdapplication(Long idapplication) {
        this.idapplication = idapplication;
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

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }
}
