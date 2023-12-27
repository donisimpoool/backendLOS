package com.ikkat.los.formapplication.applicationcollateralrealestate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "formapplication_collateral_real_estate", schema = "public")
public class ApplicationCollateralRealEstate implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="formapplication_collateral_real_estate_id_seq")
    private Long id;
    private Long idcompany;
    private Long idapplication;
    private String typerealestate;
    private String conditions;
    private int years;
    private int rooms;
    private String address;
    private String provinceid;
    private String regenciesid;
    private String districtid;
    private String sizes;
    private String proofofownership;

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

    public String getTyperealestate() {
        return typerealestate;
    }

    public void setTyperealestate(String typerealestate) {
        this.typerealestate = typerealestate;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getDistrictid() {
        return districtid;
    }

    public void setDistrictid(String districtid) {
        this.districtid = districtid;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getProofofownership() {
        return proofofownership;
    }

    public void setProofofownership(String proofofownership) {
        this.proofofownership = proofofownership;
    }
}
