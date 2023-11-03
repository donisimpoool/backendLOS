package com.ikkat.los.jsonmodel;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ikkat.los.entity.CustomerBlacklistEntity;
import com.ikkat.los.utils.Utils;

import io.swagger.annotations.ApiModelProperty;

public class CustomerBlacklistJson {
	@ApiModelProperty(value = "Set when updating, don't set to create new blacklist")
	@JsonProperty(value = "id")
	private Long blacklistId;
	@JsonProperty(value = "customerId")
	private String customerId;
	
	@ApiModelProperty(value = "Set when required", hidden = true)
	@JsonProperty(value = "externalId")
	private String externalId;
	@JsonProperty(value = "email")
	private String email;
	@JsonProperty(value = "mobile")
	private String mobile;
	@JsonProperty(value = "expiryDate")
	private long expiryDate;
	@JsonProperty(value = "active")
	private Boolean active;
	@JsonProperty(value = "notes")
	private String notes;
	@JsonProperty(value = "modifieduserid")
	private String lastmodified_by_user_id;
	
	public CustomerBlacklistEntity getEntity() {
		long now = System.currentTimeMillis();
		CustomerBlacklistEntity entity = new CustomerBlacklistEntity();
		entity.setAddedDate(Utils.longToZonedDateTime(now));
		entity.setBlacklistId(this.blacklistId);
		entity.setEmail(this.email);
		entity.setExpiryDate(Utils.longToZonedDateTime(this.expiryDate));
		entity.setIsActive(this.active);
		entity.setLastUpdated(Utils.longToZonedDateTime(now));
		entity.setNotes(this.notes);
		entity.setLastmodified_by_user_id(this.lastmodified_by_user_id);
		return entity;
	}
	public Long getBlacklistId() {
		return blacklistId;
	}
	public void setBlacklistId(Long blacklistId) {
		this.blacklistId = blacklistId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public long getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(long expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
