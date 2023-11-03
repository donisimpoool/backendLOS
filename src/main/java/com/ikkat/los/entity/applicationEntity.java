package com.ikkat.los.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.repository.Query;

import com.ikkat.los.enumeration.DateFormatEnum;
import com.ikkat.los.utils.Utils;

@Entity
@Table(name = "application", schema = "public")
public class applicationEntity implements Serializable{
	
	@Id
	@Column(name="applicationid")
	private String applicationID;
	@Column(name="status")
	private String status;
	@Column(name="score")
	private int score;
	private ZonedDateTime createddate;
	private ZonedDateTime modieddate;
	private Timestamp date;
	private String isdraft;
	private long risklevelid;
	private String scorecardcomments;
	private String ruleenginecomments;
	private String createdby;
	private boolean isexport;
	
	@OneToOne()
    @JoinColumn(name="applicationid")
    private LoanapplicationEntity loanapp;
	
	@OneToOne()
    @JoinColumn(name="applicationid")
    private applicationPersonelEntity personelapp;
	
	@OneToOne()
    @JoinColumn(name="applicationid")
    private ApplicationAddressEntity addressapp;
	
	@OneToOne()
    @JoinColumn(name="applicationid")
    private ApplicationFamilyEntity familyapp;
	
	@OneToOne()
    @JoinColumn(name="applicationid")
    private ApplicationBusinessEntity businessapp;
	
	@OneToOne()
    @JoinColumn(name="applicationid")
    private ApplicationBankEntity bankapp;
	
	@OneToOne()
    @JoinColumn(name="applicationid")
    private ApplicationFinancialEntity financialapp;
	
	@OneToOne()
    @JoinColumn(name="applicationid")
    private ApplicationCollateralEntity collateralapp;
	
	@OneToOne()
    @JoinColumn(name="applicationid")
    private ApplicationCollateralRealEstateEntity collateralreapp;
	
	@OneToOne()
    @JoinColumn(name="applicationid")
    private ApplicationCollateralDepositEntity collateraldepositapp;
	
	@OneToOne()
    @JoinColumn(name="applicationid")
    private ApplicationCollateralVehicleEntity collateralvehicleapp;
	
	@OneToOne()
    @JoinColumn(name="risklevelid",insertable = false, updatable = false)
    private RiskLevelEntity risklevel;
	
	@OneToOne()
    @JoinColumn(name="applicationid",nullable=true)
    private ApplicationDocumentEntity documentapp;
	
	@Transient
	private String datemonth;
	
	public String getDatemonth() {
		String temp = "";
		if(this.date != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatEnum.FORMAT_DATE_MONTH.value());
			temp = dateFormat.format(this.date.getTime());
		}
		return temp;
	}
	public void setDatemonth(String datemonth) {
		this.datemonth = datemonth;
	}
	public String getScorecardcomments() {
		return scorecardcomments;
	}
	public void setScorecardcomments(String scorecardcomments) {
		this.scorecardcomments = scorecardcomments;
	}
	public String getRuleenginecomments() {
		return ruleenginecomments;
	}
	public void setRuleenginecomments(String ruleenginecomments) {
		this.ruleenginecomments = ruleenginecomments;
	}
	public ApplicationDocumentEntity getDocumentapp() {
		return documentapp;
	}
	public void setDocumentapp(ApplicationDocumentEntity documentapp) {
		this.documentapp = documentapp;
	}
	public RiskLevelEntity getRisklevel() {
		return risklevel;
	}
	public void setRisklevel(RiskLevelEntity risklevel) {
		this.risklevel = risklevel;
	}
	public long getRisklevelid() {
		return risklevelid;
	}
	public void setRisklevelid(long risklevelid) {
		this.risklevelid = risklevelid;
	}
	public ApplicationCollateralRealEstateEntity getCollateralreapp() {
		return collateralreapp;
	}
	public void setCollateralreapp(ApplicationCollateralRealEstateEntity collateralreapp) {
		this.collateralreapp = collateralreapp;
	}
	public ApplicationCollateralDepositEntity getCollateraldepositapp() {
		return collateraldepositapp;
	}
	public void setCollateraldepositapp(ApplicationCollateralDepositEntity collateraldepositapp) {
		this.collateraldepositapp = collateraldepositapp;
	}
	public ApplicationCollateralVehicleEntity getCollateralvehicleapp() {
		return collateralvehicleapp;
	}
	public void setCollateralvehicleapp(ApplicationCollateralVehicleEntity collateralvehicleapp) {
		this.collateralvehicleapp = collateralvehicleapp;
	}
	public ApplicationCollateralEntity getCollateralapp() {
		return collateralapp;
	}
	public void setCollateralapp(ApplicationCollateralEntity collateralapp) {
		this.collateralapp = collateralapp;
	}
	public ApplicationFinancialEntity getFinancialapp() {
		return financialapp;
	}
	public void setFinancialapp(ApplicationFinancialEntity financialapp) {
		this.financialapp = financialapp;
	}
	public ApplicationBankEntity getBankapp() {
		return bankapp;
	}
	public void setBankapp(ApplicationBankEntity bankapp) {
		this.bankapp = bankapp;
	}
	public ApplicationBusinessEntity getBusinessapp() {
		return businessapp;
	}
	public void setBusinessapp(ApplicationBusinessEntity businessapp) {
		this.businessapp = businessapp;
	}
	public ApplicationFamilyEntity getFamilyapp() {
		return familyapp;
	}
	public void setFamilyapp(ApplicationFamilyEntity familyapp) {
		this.familyapp = familyapp;
	}
	public ApplicationAddressEntity getAddressapp() {
		return addressapp;
	}
	public void setAddressapp(ApplicationAddressEntity addressapp) {
		this.addressapp = addressapp;
	}
	public applicationPersonelEntity getPersonelapp() {
		return personelapp;
	}
	public void setPersonelapp(applicationPersonelEntity personelapp) {
		this.personelapp = personelapp;
	}
	public String getIsdraft() {
		return isdraft;
	}
	public void setIsdraft(String isdraft) {
		this.isdraft = isdraft;
	}
	public ZonedDateTime getCreateddate() {
		return createddate;
	}
	public void setCreateddate(ZonedDateTime createddate) {
		this.createddate = createddate;
	}
	public LoanapplicationEntity getLoanapp() {
		return loanapp;
	}
	public void setLoanapp(LoanapplicationEntity loanapp) {
		this.loanapp = loanapp;
	}
	public ZonedDateTime getModieddate() {
		return modieddate;
	}
	public void setModieddate(ZonedDateTime modieddate) {
		this.modieddate = modieddate;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public boolean isIsexport() {
		return isexport;
	}
	public void setIsexport(boolean isexport) {
		this.isexport = isexport;
	}
	
	
	
}
