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
@Table(name = "m_customer_blacklist")
public class CustomerBlacklistEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "M_CUSTOMER_BLACKLIST_BLACKLISTID_GENERATOR", sequenceName = "blacklist_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "M_CUSTOMER_BLACKLIST_BLACKLISTID_GENERATOR")
	@Column(name = "blacklist_id", updatable = false)
	private Long blacklistId;

	
	@Column(name = "added_date", updatable = false)
	private ZonedDateTime addedDate;

	private String email;

	@Column(name = "expiry_date")
	private ZonedDateTime expiryDate;

	@Column(name = "last_updated")
	private ZonedDateTime lastUpdated;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "notes")
	private String notes;
	
	private String mobile;
	private String lastmodified_by_user_id;

	// bi-directional many-to-one association to MCustomer
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "customer_id")
//	private CustomerEntity MCustomer;

	public Long getBlacklistId() {
		return blacklistId;
	}

	public void setBlacklistId(Long blacklistId) {
		this.blacklistId = blacklistId;
	}

	public ZonedDateTime getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(ZonedDateTime addedDate) {
		this.addedDate = addedDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ZonedDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(ZonedDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public ZonedDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(ZonedDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getLastmodified_by_user_id() {
		return lastmodified_by_user_id;
	}

	public void setLastmodified_by_user_id(String lastmodified_by_user_id) {
		this.lastmodified_by_user_id = lastmodified_by_user_id;
	}

	
}
