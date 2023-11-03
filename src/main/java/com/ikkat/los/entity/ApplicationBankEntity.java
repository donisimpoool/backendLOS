package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "application_bank", schema = "public")
public class ApplicationBankEntity implements Serializable{
	
	@Id
	private String applicationid;
	private String bankid;
	private String accounttype;
	private String accountnumber;
    private String iscreditcard;
    private String bankcc;
    private String numbercc;
    private String typecredittcard;
    
    @OneToOne()
    @JoinColumn(name="bankid",insertable = false, updatable = false)
    private BankEntity bank;
    
    @OneToOne()
    @JoinColumn(name="bankcc",insertable = false, updatable = false)
    private BankEntity bankcredit;
    
	public String getTypecredittcard() {
		return typecredittcard;
	}
	public void setTypecredittcard(String typecredittcard) {
		this.typecredittcard = typecredittcard;
	}
	public BankEntity getBankcredit() {
		return bankcredit;
	}
	public void setBankcredit(BankEntity bankcredit) {
		this.bankcredit = bankcredit;
	}
	public String getBankcc() {
		return bankcc;
	}
	public void setBankcc(String bankcc) {
		this.bankcc = bankcc;
	}
	public String getNumbercc() {
		return numbercc;
	}
	public void setNumbercc(String numbercc) {
		this.numbercc = numbercc;
	}
	public BankEntity getBank() {
		return bank;
	}
	public void setBank(BankEntity bank) {
		this.bank = bank;
	}
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String getBankid() {
		return bankid;
	}
	public void setBankid(String bankid) {
		this.bankid = bankid;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getIscreditcard() {
		return iscreditcard;
	}
	public void setIscreditcard(String iscreditcard) {
		this.iscreditcard = iscreditcard;
	}
    
    
    
    
}
