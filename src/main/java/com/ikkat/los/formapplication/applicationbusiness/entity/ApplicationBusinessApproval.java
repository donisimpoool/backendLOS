package com.ikkat.los.formapplication.applicationbusiness.entity;

import com.ikkat.los.district.entity.DistrictData;
import com.ikkat.los.province.entity.ProvinceData;
import com.ikkat.los.regencies.entity.RegenciesData;

public class ApplicationBusinessApproval {
    private String applicationid;
    private String businessline;
    private String companyaddress;
    private String companyname;
    private ProvinceData province;
    private RegenciesData regencies;
    private DistrictData district;
    private String division;
    private int duration;
    private String iddistrict;
    private String idregencies;
    private int numberofemployees;
    private String position;
    private String provinceid;

    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid;
    }

    public String getBusinessline() {
        return businessline;
    }

    public void setBusinessline(String businessline) {
        this.businessline = businessline;
    }

    public String getCompanyaddress() {
        return companyaddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public ProvinceData getProvince() {
        return province;
    }

    public void setProvince(ProvinceData province) {
        this.province = province;
    }

    public RegenciesData getRegencies() {
        return regencies;
    }

    public void setRegencies(RegenciesData regencies) {
        this.regencies = regencies;
    }

    public DistrictData getDistrict() {
        return district;
    }

    public void setDistrict(DistrictData district) {
        this.district = district;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getIddistrict() {
        return iddistrict;
    }

    public void setIddistrict(String iddistrict) {
        this.iddistrict = iddistrict;
    }

    public String getIdregencies() {
        return idregencies;
    }

    public void setIdregencies(String idregencies) {
        this.idregencies = idregencies;
    }

    public int getNumberofemployees() {
        return numberofemployees;
    }

    public void setNumberofemployees(int numberofemployees) {
        this.numberofemployees = numberofemployees;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }
}
