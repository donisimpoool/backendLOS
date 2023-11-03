package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="m_loan_product")
public class LoanProductEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="loan_product_id")
	private String loanProductId;

	@Column(name="loan_description")
	private String loanDescription;

	@Column(name="loan_name")
	private String loanName;

	@Column(name = "has_collateral")
	private Boolean hasCollateral;
	
	private double minamount;
	private double maxamount;
	private int mintenor;
	private int maxtenor;
	private String filterid_h;
	private int maxreject;
	private int defaulttenor;
	private double defaultamount;
	private String isactive;
	private String externalid;
	private String renewalstatus;
	private String orientationusage;
	private String debtorcategory;
	private String financingcode;
	private String traidcode;
	private String interestrateperperiod;
	private String interesttype;
	private String amortizationtype;
	private String interestcalculationperiodtype;
	private String transactionprocessingstrategyid;
	private String loanpurposeid;
	private String economisector;
	private String economisectordetail;
	private String repaymentevery;
	private String repaymentfrequencytype;

	public String getRepaymentevery() {
		return repaymentevery;
	}

	public void setRepaymentevery(String repaymentevery) {
		this.repaymentevery = repaymentevery;
	}

	public String getRepaymentfrequencytype() {
		return repaymentfrequencytype;
	}

	public void setRepaymentfrequencytype(String repaymentfrequencytype) {
		this.repaymentfrequencytype = repaymentfrequencytype;
	}

	public String getEconomisector() {
		return economisector;
	}

	public void setEconomisector(String economisector) {
		this.economisector = economisector;
	}

	public String getEconomisectordetail() {
		return economisectordetail;
	}

	public void setEconomisectordetail(String economisectordetail) {
		this.economisectordetail = economisectordetail;
	}

	public String getLoanpurposeid() {
		return loanpurposeid;
	}

	public void setLoanpurposeid(String loanpurposeid) {
		this.loanpurposeid = loanpurposeid;
	}

	public String getTransactionprocessingstrategyid() {
		return transactionprocessingstrategyid;
	}

	public void setTransactionprocessingstrategyid(String transactionprocessingstrategyid) {
		this.transactionprocessingstrategyid = transactionprocessingstrategyid;
	}

	public String getInterestcalculationperiodtype() {
		return interestcalculationperiodtype;
	}

	public void setInterestcalculationperiodtype(String interestcalculationperiodtype) {
		this.interestcalculationperiodtype = interestcalculationperiodtype;
	}

	public String getAmortizationtype() {
		return amortizationtype;
	}

	public void setAmortizationtype(String amortizationtype) {
		this.amortizationtype = amortizationtype;
	}

	public String getInteresttype() {
		return interesttype;
	}

	public void setInteresttype(String interesttype) {
		this.interesttype = interesttype;
	}

	public String getInterestrateperperiod() {
		return interestrateperperiod;
	}

	public void setInterestrateperperiod(String interestrateperperiod) {
		this.interestrateperperiod = interestrateperperiod;
	}

	public String getTraidcode() {
		return traidcode;
	}

	public void setTraidcode(String traidcode) {
		this.traidcode = traidcode;
	}

	public String getFinancingcode() {
		return financingcode;
	}

	public void setFinancingcode(String financingcode) {
		this.financingcode = financingcode;
	}

	public String getDebtorcategory() {
		return debtorcategory;
	}

	public void setDebtorcategory(String debtorcategory) {
		this.debtorcategory = debtorcategory;
	}

	public String getOrientationusage() {
		return orientationusage;
	}

	public void setOrientationusage(String orientationusage) {
		this.orientationusage = orientationusage;
	}

	public String getRenewalstatus() {
		return renewalstatus;
	}

	public void setRenewalstatus(String renewalstatus) {
		this.renewalstatus = renewalstatus;
	}

	public String getExternalid() {
		return externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public int getDefaulttenor() {
		return defaulttenor;
	}

	public void setDefaulttenor(int defaulttenor) {
		this.defaulttenor = defaulttenor;
	}

	public double getDefaultamount() {
		return defaultamount;
	}

	public void setDefaultamount(double defaultamount) {
		this.defaultamount = defaultamount;
	}

	public int getMaxreject() {
		return maxreject;
	}

	public void setMaxreject(int maxreject) {
		this.maxreject = maxreject;
	}

	public LoanProductEntity() {
	}

	@PrePersist
	public void onPrePersist() {
		if (hasCollateral == null) {
			hasCollateral = false;
		}
	}
	
	@PreUpdate
	public void onPreUpdate() {
		onPrePersist();
	}

	public String getFilterid_h() {
		return filterid_h;
	}

	public void setFilterid_h(String filterid_h) {
		this.filterid_h = filterid_h;
	}

	public double getMinamount() {
		return minamount;
	}

	public void setMinamount(double minamount) {
		this.minamount = minamount;
	}

	public double getMaxamount() {
		return maxamount;
	}

	public void setMaxamount(double maxamount) {
		this.maxamount = maxamount;
	}

	public int getMintenor() {
		return mintenor;
	}

	public void setMintenor(int mintenor) {
		this.mintenor = mintenor;
	}

	public int getMaxtenor() {
		return maxtenor;
	}

	public void setMaxtenor(int maxtenor) {
		this.maxtenor = maxtenor;
	}

	public String getLoanProductId() {
		return loanProductId;
	}

	public void setLoanProductId(String loanProductId) {
		this.loanProductId = loanProductId;
	}

	public String getLoanDescription() {
		return loanDescription;
	}

	public void setLoanDescription(String loanDescription) {
		this.loanDescription = loanDescription;
	}

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public Boolean getHasCollateral() {
		return hasCollateral;
	}

	public void setHasCollateral(Boolean hasCollateral) {
		this.hasCollateral = hasCollateral;
	}

//	public Double getAnnualInterestRateMax1() {
//		return annualInterestRateMax1;
//	}
//
//	public void setAnnualInterestRateMax1(Double annualInterestRateMax1) {
//		this.annualInterestRateMax1 = annualInterestRateMax1;
//	}
}
