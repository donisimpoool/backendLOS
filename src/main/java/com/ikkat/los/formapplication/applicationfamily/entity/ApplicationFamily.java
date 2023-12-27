package com.ikkat.los.formapplication.applicationfamily.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "formapplication_family", schema = "public")
public class ApplicationFamily implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="formapplication_family_id_seq")
    private Long id;
    private Long idcompany;
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

    public Long getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(Long idcompany) {
        this.idcompany = idcompany;
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
