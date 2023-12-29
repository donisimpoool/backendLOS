package com.ikkat.los.formapplication.applicationscore.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "formapplication_score", schema = "public")
public class ApplicationScore implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="formapplication_score_id_seq")
    private Long id;
    private Long idcompany;
    private Long idapplication;
    private int propertypossession;
    private int numberofdependant;
    private int gender;
    private int locations;
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
    private int positions;

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

    public int getLocations() {
        return locations;
    }

    public void setLocations(int locations) {
        this.locations = locations;
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

    public int getPositions() {
        return positions;
    }

    public void setPositions(int positions) {
        this.positions = positions;
    }
}
