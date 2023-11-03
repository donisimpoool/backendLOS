package com.ikkat.los.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "m_credit_score")
public class CreditScoreEntity {
	public CreditScoreEntity() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cs_id")
	private Long id;
	
	private String name;
	
	@JsonProperty(value = "description")
	private String description;
	
	@Column(name = "last_updated")
	private ZonedDateTime lastUpdated;
	
	@Column(name = "cs_classname")
	private String creditScoreClassName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ZonedDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(ZonedDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getCreditScoreClassName() {
		return creditScoreClassName;
	}

	public void setCreditScoreClassName(String creditScoreClassName) {
		this.creditScoreClassName = creditScoreClassName;
	}
}
