package com.ikkat.los.formapplication.applicationaddress.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "formapplication_address", schema = "public")
public class ApplicationAddress implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="formapplication_address_id_seq")
    private Long id;
    private Long idcompany;
    private Long idapplication;
    private String mainaddress;
    private String provinceid;
    private String postalcode;
    private String ownershipstatus;
    private String usedforcollateral;
    private String liveinaddress;
    private String secondaddress;
    private String secondprovinceid;
    private String secondpostalcode;
    private String secondownershipstatus;
    private String secondusedforcollateral;
    private String idregencies;
    private String iddistrict;
    private String secondidregencies;
    private String secondiddistrict;
    private String locationaddress;
    private String rt;
    private String rw;
    private Long villagesid;

    public Long getIdapplication() {
        return idapplication;
    }

    public void setIdapplication(Long idapplication) {
        this.idapplication = idapplication;
    }

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

    public String getMainaddress() {
        return mainaddress;
    }

    public void setMainaddress(String mainaddress) {
        this.mainaddress = mainaddress;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getOwnershipstatus() {
        return ownershipstatus;
    }

    public void setOwnershipstatus(String ownershipstatus) {
        this.ownershipstatus = ownershipstatus;
    }

    public String getUsedforcollateral() {
        return usedforcollateral;
    }

    public void setUsedforcollateral(String usedforcollateral) {
        this.usedforcollateral = usedforcollateral;
    }

    public String getLiveinaddress() {
        return liveinaddress;
    }

    public void setLiveinaddress(String liveinaddress) {
        this.liveinaddress = liveinaddress;
    }

    public String getSecondaddress() {
        return secondaddress;
    }

    public void setSecondaddress(String secondaddress) {
        this.secondaddress = secondaddress;
    }

    public String getSecondprovinceid() {
        return secondprovinceid;
    }

    public void setSecondprovinceid(String secondprovinceid) {
        this.secondprovinceid = secondprovinceid;
    }

    public String getSecondpostalcode() {
        return secondpostalcode;
    }

    public void setSecondpostalcode(String secondpostalcode) {
        this.secondpostalcode = secondpostalcode;
    }

    public String getSecondownershipstatus() {
        return secondownershipstatus;
    }

    public void setSecondownershipstatus(String secondownershipstatus) {
        this.secondownershipstatus = secondownershipstatus;
    }

    public String getSecondusedforcollateral() {
        return secondusedforcollateral;
    }

    public void setSecondusedforcollateral(String secondusedforcollateral) {
        this.secondusedforcollateral = secondusedforcollateral;
    }

    public String getIdregencies() {
        return idregencies;
    }

    public void setIdregencies(String idregencies) {
        this.idregencies = idregencies;
    }

    public String getIddistrict() {
        return iddistrict;
    }

    public void setIddistrict(String iddistrict) {
        this.iddistrict = iddistrict;
    }

    public String getSecondidregencies() {
        return secondidregencies;
    }

    public void setSecondidregencies(String secondidregencies) {
        this.secondidregencies = secondidregencies;
    }

    public String getSecondiddistrict() {
        return secondiddistrict;
    }

    public void setSecondiddistrict(String secondiddistrict) {
        this.secondiddistrict = secondiddistrict;
    }

    public String getLocationaddress() {
        return locationaddress;
    }

    public void setLocationaddress(String locationaddress) {
        this.locationaddress = locationaddress;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public Long getVillagesid() {
        return villagesid;
    }

    public void setVillagesid(Long villagesid) {
        this.villagesid = villagesid;
    }
}
