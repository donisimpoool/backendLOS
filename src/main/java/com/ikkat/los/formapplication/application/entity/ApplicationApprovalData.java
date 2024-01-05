package com.ikkat.los.formapplication.application.entity;

import com.ikkat.los.formapplication.applicationaddress.entity.ApplicationAppovalAddressData;
import com.ikkat.los.formapplication.applicationbank.entity.ApplicationApprovalBank;
import com.ikkat.los.formapplication.applicationbusiness.entity.ApplicationBusinessApproval;
import com.ikkat.los.formapplication.applicationcollateral.entity.ApplicationCollateralApproval;
import com.ikkat.los.formapplication.applicationcollateralrealestate.entity.ApplicationCollateralRealEstateApprovalData;
import com.ikkat.los.formapplication.applicationfamily.entity.ApplicationFamilyApprovalData;
import com.ikkat.los.formapplication.applicationfinancial.entity.ApplicationFInancialApprovalData;
import com.ikkat.los.risklevel.entity.RiskLevelApprovalData;

import java.sql.Date;

public class ApplicationApprovalData {
    private Long id;
    private Double amountloan;
    private Date createdateapplication;
    private Date createdateapplicationmonth;
    private String districtname; //
    private String fullname;
    private String[] listdoc;
    private String loanid;
    private String loannameproduct;
    private String provincename;
    private String regenciesname;
    private String status;
    private ApplicationAppovalAddressData appaddressentity;
    private ApplicationApprovalBank appbankentity;
    private ApplicationBusinessApproval appbusinessentity;
    private ApplicationCollateralApproval appcollateralentity;
    private ApplicationCollateralRealEstateApprovalData appcollateralreentity;
    //appcollateraldepositentity
    //appcollateralvehicleentity

    private App appentity;

    private ApplicationFamilyApprovalData appfamilyentity;
    private ApplicationFInancialApprovalData appfinancialentity;

    public ApplicationFInancialApprovalData getAppfinancialentity() {
        return appfinancialentity;
    }

    public void setAppfinancialentity(ApplicationFInancialApprovalData appfinancialentity) {
        this.appfinancialentity = appfinancialentity;
    }

    public App getAppentity() {
        return appentity;
    }

    public void setAppentity(App appentity) {
        this.appentity = appentity;
    }

    public ApplicationCollateralRealEstateApprovalData getAppcollateralreentity() {
        return appcollateralreentity;
    }

    public void setAppcollateralreentity(ApplicationCollateralRealEstateApprovalData appcollateralreentity) {
        this.appcollateralreentity = appcollateralreentity;
    }

    public ApplicationCollateralApproval getAppcollateralentity() {
        return appcollateralentity;
    }

    public void setAppcollateralentity(ApplicationCollateralApproval appcollateralentity) {
        this.appcollateralentity = appcollateralentity;
    }

    public ApplicationBusinessApproval getAppbusinessentity() {
        return appbusinessentity;
    }

    public void setAppbusinessentity(ApplicationBusinessApproval appbusinessentity) {
        this.appbusinessentity = appbusinessentity;
    }

    public ApplicationApprovalBank getAppbankentity() {
        return appbankentity;
    }

    public void setAppbankentity(ApplicationApprovalBank appbankentity) {
        this.appbankentity = appbankentity;
    }

    public ApplicationAppovalAddressData getAppaddressentity() {
        return appaddressentity;
    }

    public void setAppaddressentity(ApplicationAppovalAddressData appaddressentity) {
        this.appaddressentity = appaddressentity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmountloan() {
        return amountloan;
    }

    public void setAmountloan(Double amountloan) {
        this.amountloan = amountloan;
    }

    public Date getCreatedateapplication() {
        return createdateapplication;
    }

    public void setCreatedateapplication(Date createdateapplication) {
        this.createdateapplication = createdateapplication;
    }

    public Date getCreatedateapplicationmonth() {
        return createdateapplicationmonth;
    }

    public void setCreatedateapplicationmonth(Date createdateapplicationmonth) {
        this.createdateapplicationmonth = createdateapplicationmonth;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String[] getListdoc() {
        return listdoc;
    }

    public void setListdoc(String[] listdoc) {
        this.listdoc = listdoc;
    }

    public String getLoanid() {
        return loanid;
    }

    public void setLoanid(String loanid) {
        this.loanid = loanid;
    }

    public String getLoannameproduct() {
        return loannameproduct;
    }

    public void setLoannameproduct(String loannameproduct) {
        this.loannameproduct = loannameproduct;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    public String getRegenciesname() {
        return regenciesname;
    }

    public void setRegenciesname(String regenciesname) {
        this.regenciesname = regenciesname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ApplicationFamilyApprovalData getAppfamilyentity() {
        return appfamilyentity;
    }

    public void setAppfamilyentity(ApplicationFamilyApprovalData appfamilyentity) {
        this.appfamilyentity = appfamilyentity;
    }
}
