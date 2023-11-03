package com.ikkat.los.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="m_bank")
public class BankEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bank_id")
	private String bankId;

	@Column(name="bank_name", nullable = false)
	private String bankName;

//	@Column(name = "bank_code")
//	private String bankCode;
//	
//	@Column(name = "bank_long_name")
//	private String bankLongName;
//	
//	@Column(name="bank_score")
//	private Integer bankScore;
//
//	@Column(name="is_blacklisted")
//	private Boolean isBlacklisted;
//
//	@Column(name="last_updated", nullable = false)
//	private ZonedDateTime lastUpdated;

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

//	public String getBankCode() {
//		return bankCode;
//	}
//
//	public void setBankCode(String bankCode) {
//		this.bankCode = bankCode;
//	}
//
//	public String getBankLongName() {
//		return bankLongName;
//	}
//
//	public void setBankLongName(String bankLongName) {
//		this.bankLongName = bankLongName;
//	}
//
//	public Integer getBankScore() {
//		return bankScore;
//	}
//
//	public void setBankScore(Integer bankScore) {
//		this.bankScore = bankScore;
//	}
//
//	public Boolean getIsBlacklisted() {
//		return isBlacklisted;
//	}
//
//	public void setIsBlacklisted(Boolean isBlacklisted) {
//		this.isBlacklisted = isBlacklisted;
//	}
//
//	public ZonedDateTime getLastUpdated() {
//		return lastUpdated;
//	}
//
//	public void setLastUpdated(ZonedDateTime lastUpdated) {
//		this.lastUpdated = lastUpdated;
//	}
}
