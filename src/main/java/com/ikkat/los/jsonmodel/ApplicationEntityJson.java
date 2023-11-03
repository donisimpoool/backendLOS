package com.ikkat.los.jsonmodel;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import com.ikkat.los.entity.ApplicationAddressEntity;
import com.ikkat.los.entity.ApplicationBankEntity;
import com.ikkat.los.entity.ApplicationBusinessEntity;
import com.ikkat.los.entity.ApplicationCollateralDepositEntity;
import com.ikkat.los.entity.ApplicationCollateralEntity;
import com.ikkat.los.entity.ApplicationCollateralRealEstateEntity;
import com.ikkat.los.entity.ApplicationCollateralVehicleEntity;
import com.ikkat.los.entity.ApplicationFamilyEntity;
import com.ikkat.los.entity.ApplicationFinancialEntity;
import com.ikkat.los.entity.ApplicationScoreEntity;
import com.ikkat.los.entity.ListDocumentEntity;
import com.ikkat.los.entity.LoanapplicationEntity;
import com.ikkat.los.entity.applicationEntity;
import com.ikkat.los.entity.applicationPersonelEntity;
import com.ikkat.los.entity.roulesscore.RoulesScoreMaxEntity;
import com.ikkat.los.utils.Utils;

public class ApplicationEntityJson {
	private String id;
	private String loanid;
	private String fullname;
	private BigDecimal amountloan;
	private ZonedDateTime createdateapplication;
	private String status; 
	private String loannameproduct;	
	private String provincename;
	private String regenciesname;
	private String districtname;
	private String createdateapplicationmonth;
	
	private List<RoulesScoreMaxEntity> listscoremax;
	private ApplicationScoreEntity appscore;
	private List<ListDocumentEntity> listdoc;
	private applicationEntity appentity;
	private LoanapplicationEntity apploanentity;
	private applicationPersonelEntity apppersonelentity;
	private ApplicationAddressEntity appaddressentity;
	private ApplicationFamilyEntity appfamilyentity;
	private ApplicationBusinessEntity appbusinessentity;
	private ApplicationFinancialEntity appfinancialentity;
	private ApplicationBankEntity appbankentity;
	private ApplicationCollateralEntity appcollateralentity;
	private ApplicationCollateralRealEstateEntity appcollateralreentity;
	private ApplicationCollateralVehicleEntity appcollateralvehicleentity;
	private ApplicationCollateralDepositEntity appcollateraldepositentity;
	public void setvalue () {
		String date = this.appentity.getCreateddate().getDayOfMonth() +"-"+Utils.namabulan3(this.appentity.getCreateddate().getMonthValue())+"-"+this.appentity.getCreateddate().getYear()+" "+this.appentity.getCreateddate().getHour()+":"+this.appentity.getCreateddate().getMinute();
		setLoanid(this.apploanentity.getLoanproductID());
		setLoannameproduct(this.apploanentity.getLoanproduct().getLoanName());
		setFullname(this.apppersonelentity.getName());
		setAmountloan(new BigDecimal(this.apploanentity.getAmount()));
		setCreatedateapplication(this.appentity.getCreateddate());
		setCreatedateapplicationmonth(date);
		String status = "";
		if(this.appentity.getStatus().equals("A")) {
			status = "Approved";
		}else if(this.appentity.getStatus().equals("R")) {
			status = "Rejected";
		}else if(this.appentity.getStatus().equals("U")){
			status = "Underwriting";
		}else if(this.appentity.getStatus().equals("S")){
			status = "Send";
		}
		setStatus(status);
	}
	

	public ApplicationScoreEntity getAppscore() {
		return appscore;
	}


	public void setAppscore(ApplicationScoreEntity appscore) {
		this.appscore = appscore;
	}


	public List<RoulesScoreMaxEntity> getListscoremax() {
		return listscoremax;
	}


	public void setListscoremax(List<RoulesScoreMaxEntity> listscoremax) {
		this.listscoremax = listscoremax;
	}


	public String getCreatedateapplicationmonth() {
		return createdateapplicationmonth;
	}


	public void setCreatedateapplicationmonth(String createdateapplicationmonth) {
		this.createdateapplicationmonth = createdateapplicationmonth;
	}


	public List<ListDocumentEntity> getListdoc() {
		return listdoc;
	}

	public void setListdoc(List<ListDocumentEntity> listdoc) {
		this.listdoc = listdoc;
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

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public String getLoannameproduct() {
		return loannameproduct;
	}
	public void setLoannameproduct(String loannameproduct) {
		this.loannameproduct = loannameproduct;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ZonedDateTime getCreatedateapplication() {
		return createdateapplication;
	}
	public void setCreatedateapplication(ZonedDateTime createdateapplication) {
		this.createdateapplication = createdateapplication;
	}
	public BigDecimal getAmountloan() {
		return amountloan;
	}
	public void setAmountloan(BigDecimal amountloan) {
		this.amountloan = amountloan;
	}
	public String getLoanid() {
		return loanid;
	}
	public void setLoanid(String loanid) {
		this.loanid = loanid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public applicationEntity getAppentity() {
		return appentity;
	}
	public void setAppentity(applicationEntity appentity) {
		this.appentity = appentity;
	}
	public LoanapplicationEntity getApploanentity() {
		return apploanentity;
	}
	public void setApploanentity(LoanapplicationEntity apploanentity) {
		this.apploanentity = apploanentity;
	}
	public applicationPersonelEntity getApppersonelentity() {
		return apppersonelentity;
	}
	public void setApppersonelentity(applicationPersonelEntity apppersonelentity) {
		this.apppersonelentity = apppersonelentity;
	}
	public ApplicationAddressEntity getAppaddressentity() {
		return appaddressentity;
	}
	public void setAppaddressentity(ApplicationAddressEntity appaddressentity) {
		this.appaddressentity = appaddressentity;
	}
	public ApplicationFamilyEntity getAppfamilyentity() {
		return appfamilyentity;
	}
	public void setAppfamilyentity(ApplicationFamilyEntity appfamilyentity) {
		this.appfamilyentity = appfamilyentity;
	}
	public ApplicationBusinessEntity getAppbusinessentity() {
		return appbusinessentity;
	}
	public void setAppbusinessentity(ApplicationBusinessEntity appbusinessentity) {
		this.appbusinessentity = appbusinessentity;
	}
	public ApplicationFinancialEntity getAppfinancialentity() {
		return appfinancialentity;
	}
	public void setAppfinancialentity(ApplicationFinancialEntity appfinancialentity) {
		this.appfinancialentity = appfinancialentity;
	}
	public ApplicationBankEntity getAppbankentity() {
		return appbankentity;
	}
	public void setAppbankentity(ApplicationBankEntity appbankentity) {
		this.appbankentity = appbankentity;
	}
	public ApplicationCollateralEntity getAppcollateralentity() {
		return appcollateralentity;
	}
	public void setAppcollateralentity(ApplicationCollateralEntity appcollateralentity) {
		this.appcollateralentity = appcollateralentity;
	}
	public ApplicationCollateralRealEstateEntity getAppcollateralreentity() {
		return appcollateralreentity;
	}
	public void setAppcollateralreentity(ApplicationCollateralRealEstateEntity appcollateralreentity) {
		this.appcollateralreentity = appcollateralreentity;
	}
	public ApplicationCollateralVehicleEntity getAppcollateralvehicleentity() {
		return appcollateralvehicleentity;
	}
	public void setAppcollateralvehicleentity(ApplicationCollateralVehicleEntity appcollateralvehicleentity) {
		this.appcollateralvehicleentity = appcollateralvehicleentity;
	}
	public ApplicationCollateralDepositEntity getAppcollateraldepositentity() {
		return appcollateraldepositentity;
	}
	public void setAppcollateraldepositentity(ApplicationCollateralDepositEntity appcollateraldepositentity) {
		this.appcollateraldepositentity = appcollateraldepositentity;
	}
}
