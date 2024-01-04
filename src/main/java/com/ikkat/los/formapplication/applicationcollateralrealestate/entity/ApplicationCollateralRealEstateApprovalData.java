package com.ikkat.los.formapplication.applicationcollateralrealestate.entity;

import com.ikkat.los.district.entity.DistrictData;
import com.ikkat.los.province.entity.ProvinceData;
import com.ikkat.los.regencies.entity.RegenciesData;

public class ApplicationCollateralRealEstateApprovalData {
    private String applicationid;
    private String address;
    private String condition;
    private ProvinceData province;
    private RegenciesData regencies;
    private DistrictData district;
    private String districtid;
    private String proofofownership;
    private String provinceid;
    private String regenciesid;
    private int rooms;
    private String size;
    private String typerealestate;
    private int year;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
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

    public String getDistrictid() {
        return districtid;
    }

    public void setDistrictid(String districtid) {
        this.districtid = districtid;
    }

    public String getProofofownership() {
        return proofofownership;
    }

    public void setProofofownership(String proofofownership) {
        this.proofofownership = proofofownership;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    public String getRegenciesid() {
        return regenciesid;
    }

    public void setRegenciesid(String regenciesid) {
        this.regenciesid = regenciesid;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTyperealestate() {
        return typerealestate;
    }

    public void setTyperealestate(String typerealestate) {
        this.typerealestate = typerealestate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
